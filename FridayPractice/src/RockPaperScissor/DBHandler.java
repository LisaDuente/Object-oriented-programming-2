package RockPaperScissor;
import java.sql.*;
import java.util.HashMap;

public class DBHandler {
    private final String USER = "RPS_User";
    private final String PASS = "123RPS";
    private final String URL = "jdbc:mysql://localhost/rps_player";


    public void insertUser(String name){
        try{
            String query = "INSERT INTO User VALUES (Null, ?, 0, 0);";
            Connection connect = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement prep = connect.prepareStatement(query);

            prep.setString(1,name);
            prep.executeUpdate();
            //let's check if this works
            connect.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateUserOnWin(int currentWins, int ID){
        try{
            String query = "UPDATE User SET wins = ? WHERE ID = ?;";
            Connection connect = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement prep = connect.prepareStatement(query);

            prep.setInt(1, currentWins);
            prep.setInt(2, ID);
            prep.executeUpdate();
            //let's check if this works
            connect.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateUserOnLoose(int currentLoose, int ID){
        try{
            String query = "UPDATE User SET Lose = ? WHERE ID = ?;";
            Connection connect = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement prep = connect.prepareStatement(query);

            prep.setInt(1, currentLoose);
            prep.setInt(2, ID);
            prep.executeUpdate();
            //let's check if this works
            connect.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int getID(String name){
        int ID = 0;
        try{
            String query = "SELECT ID FROM user WHERE ?";
            Connection connect = DriverManager.getConnection(URL,USER,PASS);
            PreparedStatement prep = connect.prepareStatement(query);

            prep.setString(1, name);

            ResultSet result = prep.executeQuery();
            ID = result.getInt("ID");
            connect.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return ID;
    }



    public HashMap getData(){
        HashMap<Integer, String> map = new HashMap<>();
        try{
            String query = "SELECT * FROM User";
            Connection connect = DriverManager.getConnection(URL,USER,PASS);
            Statement state = connect.createStatement();
            ResultSet results = state.executeQuery(query);


            while(results.next()){
                map.put(results.getInt("ID"), results.getString("Name")+","+results.getString("Wins")+","+results.getString("Lose"));
            }
            //let's check if this works
            connect.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return map;
    }
}
