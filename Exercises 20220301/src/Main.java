import java.util.List;

/*
    - show a list of the personal
    - employ staff
    - write out warehouse status
    - order something from a shipper (??)
    - use the terminal!
 */

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/ikea";
        String user = "Lisa";
        String pass = "123lisa";
        String queryDownload = "SELECT * FROM quantityinwarehouse;";
        String queryUpload = "INSERT INTO cities VALUES (12,'Köln','DE');";
        String queryPrep = "UPDATE cities SET CityName = ? WHERE CityId = ?";


        SQLConnect connector = new SQLConnect(url, user, pass);
        //connector.uploadToDatabase(queryUpload);
        //this one can be recycled with new updates on cities
        //connector.preparedStatement1(queryPrep,"Babelsberg", 11);
        //connector.callStockUpp(1,1,5);
        //connector.printResults(connector.executeQuery(queryDownload),"ID,ProductName,TotalQuantity");

        //save the result set in a list (within the method) and then stream it
        //takes out all products that contain a t
        connector.resultSetToList(queryDownload, "ID,ProductName,TotalQuantity")
                .stream().
                map(e -> e.split(","))
                .filter(e -> e[2].contains("t"))
                .forEach(e -> System.out.println(e[2]));

        System.out.println("____________________________________");

        //takes out all products that have more than 100 in the warehouses
        connector.resultSetToList(queryDownload, "ID,ProductName,TotalQuantity")
                .stream().
                map(e -> e.split(","))
                .filter(e -> Integer.parseInt(e[3]) > 100)
                .forEach(e -> System.out.println(e[2]));

        System.out.println("____________________________________");

        //because we operate on the keyset we can only print out keys
        connector.resultSetToMap(queryDownload,"ID,ProductName,TotalQuantity")
                .keySet()
                .stream()
                .filter(e -> e%2 == 0)
                .forEach(e -> System.out.println(e));

        System.out.println("____________________________________");

    //if you only want to operate on the values
        connector.resultSetToMap(queryDownload,"ID,ProductName,TotalQuantity")
                .values()
                .stream()
                .map(e -> e.split(","))
                .filter(e -> e[1].contains("am"))
                .forEach(e -> System.out.println(e[1]));

        System.out.println("____________________________________");

        //if you want to operate on the whole map
        connector.resultSetToMap(queryDownload,"ID,ProductName,TotalQuantity")
                .entrySet()
                .stream()
                .map(e -> e.getValue().split(","))
                .filter(e -> e[1].contains("am"))
                .forEach(e -> System.out.println(e[1]));
    }
}
