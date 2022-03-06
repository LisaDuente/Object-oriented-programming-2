package RockPaperScissor;

public class Controller {
    private User user;
    private Menu menu;
    private GameEngine game;
    private GameSaveDB saver;
    private View view;
    private String currentUserName;

    public Controller(){
        this.view = new View("Rock Paper Scissors");
        this.menu = new Menu();
        this.game = new GameEngine();
        this.saver = new GameSaveDB();

    }

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
                    game.playGame(this.user, this.view);
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

    /*public void doTheLoad(){
        this.user = saver.loadUser();
    }*/

    public GameEngine getGame() {
        return game;
    }

    public User getUser() {
        return user;
    }
}
