package RockPaperScissor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class GameSaveDB {

    DBHandler db = new DBHandler();
    HashMap<String, String> map;

    public GameSaveDB(){
        this.map = db.getData();
    }

    //maybe not that cool but to try out streams with maps
    public User buildAUser(String userName){
       List<String> usersName = this.map.entrySet()
               .stream()
               .filter(e -> userName.equals(e.getKey()))
               .map(e -> e.getValue())
               .map(e -> e.split(","))
               .map(e -> e[0])
               .toList();

        List<Integer> wins = this.map.entrySet()
                .stream()
                .filter(e -> userName.equals(e.getKey()))
                .map(e -> e.getValue())
                .map(e -> e.split(","))
                .map(e -> Integer.parseInt(e[1]))
                .toList();

        List<Integer> lose = this.map.entrySet()
                .stream()
                .filter(e -> userName.equals(e.getKey()))
                .map(e -> e.getValue())
                .map(e -> e.split(","))
                .map(e -> Integer.parseInt(e[2]))
                .toList();

        User user = new User();
        user.setName(usersName.get(0));
        user.setWin(wins.get(0));
        user.setLoose(lose.get(0));
        return user;
    }

    public void saveAUser(User user, String userName){
        this.map.put(userName, user.getName()+","+user.getWin()+","+user.getLoose());
        db.updateUserOnWin(user.getWin(),userName);
        db.updateUserOnLoose(user.getLoose(),userName);
    }

    public HashMap<String, String> getMap() {
        return map;
    }
}
