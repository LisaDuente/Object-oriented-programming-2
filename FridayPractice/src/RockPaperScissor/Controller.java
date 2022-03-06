package RockPaperScissor;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Model model;
    private User user;
    private Menu menu;
    private GameEngine game;
    private GameSaveDB saver;
    private String currentUserName;

    public Controller(Model model){
        this.model = model;
        this.menu = new Menu();
        this.game = new GameEngine();
        this.saver = new GameSaveDB();

    }

    public void playGame(String input){
        if(this.user == null){
            this.model.setMessage("error");
        }else{
            this.model.setMessage("Welcome to Rock Paper Scissors!");
        }

        switch(input){
            case "scissors":
                this.model.setInputUser("scissors");
                this.game.setInput("scissors");
                break;
            case "rock":
                this.model.setInputUser("rock");
                this.game.setInput("rock");
                break;
            case "paper":
                this.model.setInputUser("paper");
                this.game.setInput("paper");
                break;
            default:
                System.out.println("Controller::setInput:error");
        }
        this.game.setComputer();
        this.model.setInputComputer(this.game.getComputer());
        this.game.compareChoice();
        this.game.checkWin();

        if(!this.game.isRunning() && this.game.getWinUser() == 3){
            this.model.setMessage("You won");
            this.user.setWin(this.user.getWin()+1);
            this.model.setUser(this.user);
            this.saver.saveAUser(this.user, this.currentUserName);
            this.game.resetGame();
        }else if( !this.game.isRunning() && this.game.getWinComputer() == 3){
            this.model.setMessage("You lost");
            this.user.setWin(this.user.getLoose()+1);
            this.model.setUser(this.user);
            this.saver.saveAUser(this.user, this.currentUserName);
            this.game.resetGame();
        }
    }

    public void loadUser(String s){
        //depends a little bit on the list, how to get the name out of the list
        this.user = saver.buildAUser(s);
        this.currentUserName = s;
        model.setUser(this.user);
    }

    public GameSaveDB getSaver() {
        return saver;
    }

    public void resetGame(){
        this.game.resetGame();
    }

    /*
    public void gameLoop(){

        while(game.getIsMenuRunning()){
            menu.printMenu();
            switch(game.getInput()){
                case "1":
                    //we need a method here to give the function a userName from the view
                    this.currentUserName = "NeonPinky";
                    this.user = saver.buildAUser(currentUserName);
                    break;
                case "2":
                    if(user == null){
                        System.out.println("Please choose a user first!\n");
                        break;
                    }
                    game.playGame(this.user);
                    this.user.showStats();
                    saver.saveAUser(this.user, this.currentUserName);
                    game.resetGame();
                    break;
                case "3":
                    game.setMenuIsRunning(false);
                    break;
                default:
                    System.out.println("Sorry, wrong input!");
            }
        }
    }

 */

    /*public void doTheLoad(){
        this.user = saver.loadUser();
    }*/

    public GameEngine getGame() {
        return game;
    }

    public User getUser() {
        return user;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
}
