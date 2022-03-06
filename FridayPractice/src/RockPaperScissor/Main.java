package RockPaperScissor;

import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        //small tests
        //DBHandler db = new DBHandler();
        //HashMap<String, String> map = db.getData();
        //System.out.println(map.keySet() + " "+ map.values());
        //db.insertUser("NeonPinky","Lisa");
        //GameSaveDB saver = new GameSaveDB();


        //Playing the game
        //View view = new View("Rock Paper Scissors");
        Controller control = new Controller();
        control.gameLoop();

    }

}