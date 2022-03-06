import RockPaperScissor.DBHandler;
import RockPaperScissor.GameSave;
import RockPaperScissor.User;

import java.util.HashMap;

public class GameSaveDB {

    DBHandler db = new DBHandler();
    HashMap map;

    public GameSaveDB(){
        this.map = db.getData();
    }

    //stream the values (string) for the ID and build a user with those values (use split)
    public void buildAUser(User user, int ID){
        this.map.entrySet()
                .stream()
    }
}
