import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionManager {

    //object to couple the program to a URL
    private HttpURLConnection connection;

    public String sendRequest(String request){
        String line = "";
        String response = "";
        try {
            URL url = new URL("http://localhost:8080/"+request);
            this.connection = (HttpURLConnection) url.openConnection();

            //choose what you want to do, just now we want to get something
            this.connection.setRequestMethod("GET");
            //set a timeout, if you cant create a connection within this time, break connection
            this.connection.setConnectTimeout(5000);
            //same for read
            this.connection.setReadTimeout(5000);

            //every status under 300 no error, we want to have 200(OK)
            int status = connection.getResponseCode();
            System.out.println("status: "+status);

            if(status < 300){
                //we want to have a stream if the status is ok,
                //to handle the input stream we gonna read it with an inputStreamReader
                //to handle it the best way, lay it in a bufferedReader
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                //concat everything in response
                while((line = reader.readLine())!= null){
                    response += line;
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
