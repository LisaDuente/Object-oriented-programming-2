import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSave {
    private File save;
    private ArrayList<String> userInfo;

    public GameSave(String path){
        this.save = new File(path);
        this.userInfo = new ArrayList<>();
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

        //check if a user already exists
        /*for(int i = 0; i<userInfo.size(); i++){
            String line = userInfo.get(i);
            String[] partHolder = line.split(",");
            if()
        }*/

        String line = user.getName()+","+user.getWin()+","+user.getLoose();
        userInfo.add(line);
    }

    public void loadUser(User user){
        System.out.println("Please insert username: ");
        Scanner scanner = new Scanner (System.in);
        String userName = scanner.next();

        for(int i = 0; i<userInfo.size(); i++){
            String line = userInfo.get(i);
            String[] partHolder = line.split(",");
            if(userName.equals(partHolder[0])){
                user.setName(userName);
                user.setWin(Integer.parseInt(partHolder[1]));
                user.setLoose(Integer.parseInt(partHolder[2]));
                break;

            }

        }
    }

}
