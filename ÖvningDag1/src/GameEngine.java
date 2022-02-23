import java.util.Scanner;

public class GameEngine {
    private RockPaperScissor currentGame;
    private int winComputer;
    private int winUser;
    private boolean running;
    private String input;
    private String computer;

    public GameEngine(){
        currentGame = new RockPaperScissor();
        winComputer = 0;
        winUser = 0;
        running = true;
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
        if(this.input.equalsIgnoreCase("sax") && this.computer.equals("sten")){
            winComputer++;
        }else if(this.input.equalsIgnoreCase("sax") && this.computer.equals("påse")){
            winUser++;
        }else if(this.input.equalsIgnoreCase("sten") && this.computer.equals("påse")){
            winComputer++;
        }else if(this.input.equalsIgnoreCase("sten") && this.computer.equals("sax")){
            winUser++;
        }else if(this.input.equalsIgnoreCase("påse") && this.computer.equals("sten")){
            winUser++;
        }else if(this.input.equalsIgnoreCase("påse") && this.computer.equals("sax")){
            winComputer++;
        }
    }

    public void checkWin(){
        if(winComputer == 3 || winUser == 3){
            running = false;
        }
    }

    public void welcome(){
        System.out.println("## Welcome to Rock Paper Scissors! ##");
    }

    public void playGame(User user){
        while(running){
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
}
