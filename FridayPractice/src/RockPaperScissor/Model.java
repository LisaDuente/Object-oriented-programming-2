package RockPaperScissor;

public class Model {
    private User user;
    private Menu menu;
    private GameEngine game;
    private GameSaveDB saver;
    private String currentUserName;
    private String error;
    private String message;
    private String input;

    public Model(){
        this.menu = new Menu();
        this.game = new GameEngine();
        this.saver = new GameSaveDB();
    }

    public void gameLoop(){

        while(game.getIsMenuRunning()){
            switch(this.input){
                case "1":
                    this.user = saver.buildAUser(currentUserName);
                    break;
                case "2":
                    if(user == null){
                        this.error = "Please choose a user first!";
                        break;
                    }
                    game.playGame(this.user);
                    this.message = this.user.showStats();
                    saver.saveAUser(this.user, this.currentUserName);
                    game.resetGame();
                    break;
                case "3":
                    game.setMenuIsRunning(false);
                    break;
                default:
                    this.error = "Sorry, wrong input!";
            }
        }
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
