package RockPaperScissor;

public class Controller {
    private User user;
    private Menu menu;
    private GameEngine game;
    private GameSave saver;

    public Controller(){
        this.menu = new Menu();
        this.game = new GameEngine();
        this.saver = new GameSave("src/RockPaperScissor/Save.txt");

    }

    public void gameLoop(){

        while(game.getIsMenuRunning()){
            menu.printMenu();
            switch(game.getInput()){
                case "1":
                    this.user = saver.loadUser();
                    break;
                case "2":
                    if(user == null){
                        System.out.println("Please choose a user first!\n");
                        break;
                    }
                    game.playGame(this.user);
                    this.user.showStats();
                    saver.saveUserInHashMap(this.user);
                    saver.saveFromMapToFile();
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

    public void doTheLoad(){
        this.user = saver.loadUser();
    }

    public GameEngine getGame() {
        return game;
    }

    public User getUser() {
        return user;
    }
}
