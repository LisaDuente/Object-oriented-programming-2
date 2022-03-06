import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLConnect {
        private final String URL;
        private final String USER;
        private final String PASS;
        //make a new connection for each statement and make a new statement for each query
        //private Connection connect;

    public SQLConnect(String url, String user, String pass){
        // don't use your root if you want to be save
        this.URL= url;
        this.USER = user;
        this.PASS = pass;

    }
    //with the next two methods you download data from the db to your program
    public ResultSet executeQuery(String query){
        try {
            Connection connect = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement state = connect.createStatement();
            //to execute a query in the database, save it in a ResultSet to save all results
           ResultSet result = state.executeQuery(query);
           return result;
        }catch(SQLException e){
            e.printStackTrace();
        }
        ResultSet result1 = null;
        return result1;
    }

    public void printResults( ResultSet set, String columns){
        try{
            String[] columnNames = columns.split(",");
            //takes every row
        while(set.next()) {
            //for all elements in columnName
            for(int i = 0; i < columnNames.length; i++) {
                //it prints out the column name and the value saved in the column name
                System.out.print(columnNames[i]+" : "+set.getString(columnNames[i])+" | ");
            }
            System.out.println();
        }
        }catch(SQLException e){
            e.printStackTrace();
            }
        }

        //method to update the database
        public void uploadToDatabase(String query){
        try {
            Connection connect = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement state = connect.createStatement();
            state.executeUpdate(query);
            connect.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        }

        public void preparedStatement1(String query,String cityName, int cityId){
            try{
                Connection connect = DriverManager.getConnection(this.URL, this.USER, this.PASS);
                PreparedStatement prep = connect.prepareStatement(query);

                prep.setString(1, cityName);
                prep.setInt(2, cityId);

                prep.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        public void callStockUpp(int wareHouseID, int productID, int newQuantity){
            String query = "{CALL StockUPP(?,?,?)}";
        try{
            Connection connect = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            CallableStatement call = connect.prepareCall(query);

            call.setInt(1, wareHouseID);
            call.setInt(2,productID);
            call.setInt(3, newQuantity);

            //sometimes you need to save the result in a resultset if you want to print it out
            call.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> resultSetToList(String query, String columnNames){
        ArrayList<String> list = new ArrayList<>();
        try {
            String[] columns = columnNames.split(",");
            int length = columns.length;
            Connection connect = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(query);


            while(result.next()){
                String concat = "";
                for(int i = 0; i<length; i++){
                    concat = concat +","+result.getString(columns[i]);
                }
                list.add(concat);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public Map<Integer,String> resultSetToMap(String query, String columnNames){
        Map<Integer,String> map = new HashMap<>();
        try {
            String[] columns = columnNames.split(",");
            int length = columns.length;
            Connection connect = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            Statement state = connect.createStatement();
            ResultSet result = state.executeQuery(query);

            //doesnt work with maps like this
            while(result.next()){
                String concat = "";
                for(int i = 1; i<length; i++){
                    concat = concat +","+result.getString(columns[i]);
                }
                map.put(result.getInt(columns[0]),concat);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return map;
    }


    }



