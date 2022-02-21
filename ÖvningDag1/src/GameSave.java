import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSave {
    private File save;
    private ArrayList<String> userInfo;

    public GameSave(String path){
        save = new File(path);
        userInfo = new ArrayList<>();
    }

    public void readFromFile(){
        try {
            Scanner scanner = new Scanner(save);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                userInfo.add(line);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveToFile(){
        try {
            PrintWriter writer = new PrintWriter(save);
            for(String line : userInfo){
                writer.println(line);
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveUserInArray(User user){
        String line = user.getName()+","+user.getWin()+","+user.getLoose();
        userInfo.add(line);
    }

}
