package RockPaperScissor;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Model model;

    public Controller(Model model){
        this.model = model;

    }

    public void playGame(String input){
        if(this.model.getUser() == null){
            this.model.setMessage("error");
        }else{
            this.model.setMessage("Welcome to Rock Paper Scissors!");
        }

        switch(input){
            case "scissors":
                this.model.setInputUser("scissors");
                this.model.getGame().setInput("scissors");
                break;
            case "rock":
                this.model.setInputUser("rock");
                this.model.getGame().setInput("rock");
                break;
            case "paper":
                this.model.setInputUser("paper");
                this.model.getGame().setInput("paper");
                break;
            default:
                System.out.println("Controller::setInput:error");
        }
        this.model.getGame().setComputer();
        this.model.setInputComputer(this.model.getGame().getComputer());
        this.model.getGame().compareChoice();
        this.model.getGame().checkWin();

        if(!this.model.getGame().isRunning() && this.model.getGame().getWinUser() == 3){
            this.model.setMessage("You won");
            this.model.getUser().setWin(this.model.getUser().getWin()+1);
            this.model.getSaver().saveAUser(this.model.getUser(), this.model.getCurrentUserName());
            this.model.getGame().resetGame();
        }else if( !this.model.getGame().isRunning() && this.model.getGame().getWinComputer() == 3){
            this.model.setMessage("You lost");
            this.model.getUser().setLoose(this.model.getUser().getLoose()+1);
            this.model.getSaver().saveAUser(this.model.getUser(), this.model.getCurrentUserName());
            this.model.getGame().resetGame();
        }
    }

    public void loadUser(String s){
        //depends a little bit on the list, how to get the name out of the list
        this.model.setUser(this.model.getSaver().buildAUser(s));
        this.model.setCurrentUserName(s);
    }

    public Model getModel() {
        return model;
    }

    public void resetGame(){
        this.model.getGame().resetGame();
    }
}
