package RockPaperScissor;

import java.util.Scanner;

public class GameEngine {
    private RockPaperScissor currentGame;
    private int winComputer;
    private int winUser;
    private boolean running;
    private boolean menuIsRunning;
    private String input;
    private String computer;

    public GameEngine(){
        currentGame = new RockPaperScissor();
        winComputer = 0;
        winUser = 0;
        running = true;
        menuIsRunning = true;
        input = "";
        computer = "";
    }

    public void getInputSpel() {
        Scanner scanner = new Scanner(System.in);
        String usersChoice = scanner.next();
        this.input = usersChoice;
    }

    public void setComputer() {
        this.computer = currentGame.randomizeChoice();
    }

    public void compareChoice(){
        //equalsIgnoreCase can be used instead of .toLowerCase/UpperCase
        if(this.input.equalsIgnoreCase("scissors") && this.computer.equals("rock")){
            winComputer++;
        }else if(this.input.equalsIgnoreCase("scissors") && this.computer.equals("paper")){
            winUser++;
        }else if(this.input.equalsIgnoreCase("rock") && this.computer.equals("paper")){
            winComputer++;
        }else if(this.input.equalsIgnoreCase("rock") && this.computer.equals("scissors")){
            winUser++;
        }else if(this.input.equalsIgnoreCase("paper") && this.computer.equals("rock")){
            winUser++;
        }else if(this.input.equalsIgnoreCase("paper") && this.computer.equals("scissors")){
            winComputer++;
        }
    }

    public void checkWin(){
        if(winComputer == 3 || winUser == 3){
            running = false;
        }
    }

    public void playGame(User user, View view){
        System.out.println("Hey "+ user.getName()+"!");
        while(running){
            view.setScore("You: " + this.winUser + " | Computer: " + this.winComputer);
            System.out.println("______________________________________________");
            System.out.print("Please make your choice: ");
            getInputSpel();
            setComputer();
            System.out.println("You: " + this.input +" | Computer: "+this.computer);
            compareChoice();
            showScore();
            checkWin();
        }
        if(winUser == 3){
            user.setWin(user.getWin()+1);
        }else{
            user.setLoose(user.getLoose()+1);
        }
    }

    public void showScore(){
        System.out.println("You won: " + this.winUser + " times | Computer won: " + this.winComputer +" times!");
    }

    public void resetGame(){
        this.winComputer = 0;
        this.winUser = 0;
        this.running = true;
    }

    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toLowerCase();
        return input;
    }

    public boolean getIsMenuRunning() {
        return menuIsRunning;
    }

    public void setMenuIsRunning(boolean menuIsRunning) {
        this.menuIsRunning = menuIsRunning;
    }

    public int getWinComputer() {
        return winComputer;
    }

    public int getWinUser() {
        return winUser;
    }
}