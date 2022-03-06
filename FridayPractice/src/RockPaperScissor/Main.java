package RockPaperScissor;

public class Main {
    public static void main (String[] args) {
        DBHandler db = new DBHandler();
        //db.insertUser("Lisa");
        db.updateUserOnLoose(3,1);
        //View view = new View("Rock Paper Scissors");
        //Controller control = new Controller();
        //control.gameLoop();

    }

}