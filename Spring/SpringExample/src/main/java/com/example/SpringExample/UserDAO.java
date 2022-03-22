package com.example.SpringExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//this is the model in the MVC design pattern
//data access object, needs to have the @Component or @Repository annotation
//this object will connect with the database
@Repository
public class UserDAO {

    //@Autowired finds all the connections, going to reach the properties file and get the datasources
    //everything will be saved in the template
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertNewUser(String ID, String name){
        String query = "INSERT INTO user VALUES(?,?,0,0);";

        //to send the query via the template to our database
        //the result is going to be the number of rows that is affected
        int result = jdbcTemplate.update(query,ID,name);

        if(result>0){
            System.out.println(result + " user added to database");
        }
    }

    public User downloadUser(String ID){
        String query = "SELECT * FROM user WHERE ID = ?;";
        //to get out an object, first the query, then a rowmapper, parameter for ?
        //the rowmapper helps you handle the resultset of the query
        //and with the help of that you can create a user
        User user = jdbcTemplate.queryForObject(query, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                //create a new user and get the name and ID from the result set
                User userIn = new User(rs.getString("ID"),
                        rs.getString("Name"),
                        rs.getInt("Wins"),
                        rs.getInt("Lose"));
                return userIn;
            }
        }, ID);
       return user;
    }

    //if you insert many users at a time and have an auto increase, it can happen that they
    //get the same ID if you insert them in kombination with the getMaxUserID method!
    public void insertNewUsers(List<User> userList){
        String query = "INSERT INTO user VALUES (?,?,0,0);";
        //a batchPreparedStatementSetter iterates over the list and takes in many parameters

        int[] batchSize = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                //get the one customer from the list
                User user = userList.get(i);
                //the int describes the questionmark's place in the prepared statement
                ps.setString(1, user.getID());
                ps.setString(2,user.getName());
            }

            @Override
            public int getBatchSize() {
                return userList.size();
            }
        });
        System.out.println(batchSize + "users added to the database");
    }

    //a method to get out the highest int from a table but this wont work because I work with strings here
    public String getMaxUserID(){
        String query = "SELECT MAX(userID) FROM user;";

        return jdbcTemplate.queryForObject(query, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                //this time the result set is only one row
                return new User(String.valueOf(rs.getInt("MAX(ID)")), "Lisa");
            }
        }).getID();

    }

    public List<User> getAllUsers(){
       String query = "SELECT * FROM user";
       //this function will return a list of maps with string key and an object//
        //the key would be the name of the column and the value will be the saved info
        //first map: ID : 1, name : Lisa, wins : 0, lose : 0
        //secon map: ID : Bämbel, name : Armanda, wins: 4, lose : 5 etc.
       List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
       List<User> userList = new ArrayList<>();

       for(Map<String, Object> row : rows){
           //dont forget to cast the objects from the map to the right datatypes
           User user = new User(String.valueOf(row.get("ID")),
                   String.valueOf(row.get("Name")),
                   (int) row.get("Wins"),
                   (int)row.get("Lose"));
           userList.add(user);
       }
       return userList;
    }

}
