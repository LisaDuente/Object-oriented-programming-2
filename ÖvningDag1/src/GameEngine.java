import java.util.Scanner;

public class GameEngine {
    private RockPaperScissor currentGame;
    private int winComputer;
    private int winUser;
    private boolean running;
    private boolean menuIsRunning;
    private String input;
    private String computer;
    private User user;

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

    public void playGame(User user){
        System.out.println("Hey "+ user.getName()+"!");
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

    public void gameLoop(GameSave saver, Menu menu){

        while(this.menuIsRunning){
            menu.printMenu();
            switch(getInput()){
                case "1":
                    this.user = saver.loadUser();
                    break;
                case "2":
                    if(user == null){
                        System.out.println("Please choose a user first!\n");
                        break;
                    }
                    playGame(this.user);
                    this.user.showStats();
                    saver.saveUserInHashMap(this.user);
                    saver.saveFromMapToFile();
                    resetGame();
                    break;
                case "3":
                    this.menuIsRunning = false;
                    break;
                default:
                    System.out.println("Sorry, wrong input!");


            }
        }
    }
}
