package RockPaperScissor;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class GameSave {
    private File save;
    private HashMap<String, User> users;

    public GameSave(String path){
        this.save = new File(path);
        this.users = new HashMap<>();

    }

    public void printUsers(){
        for(User user : this.users.values()){
            user.showStats();
        }
    }

    private void readFromFileToHashMap(){
        try {
            Scanner scanner = new Scanner(save);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] partHolder = line.split(",");
                users.put(partHolder[0], new User(partHolder[0],Integer.parseInt(partHolder[1]),
                        Integer.parseInt(partHolder[2])));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveUserInHashMap(User user){
        users.put(user.getName(),user);
    }

    public void saveFromMapToFile(){
        try {
            PrintWriter writer = new PrintWriter(save);
            for(User values : users.values()){
                writer.println(values.getName()+","+values.getWin()+","+values.getLoose());
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public User loadUser(){
        User user = new User();
        System.out.println("Please insert username: ");
        Scanner scanner = new Scanner (System.in);
        String userName = scanner.next();
        if(users.containsKey(userName)){
            user = users.get(userName);
        }else{
            System.out.println("This user doesn't exist. Please create a new one: ");
            user.chooseName();
            user.setLoose(0);
            user.setWin(0);
        }

        return user;
    }


}
