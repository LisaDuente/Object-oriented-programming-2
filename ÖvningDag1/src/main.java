public class main {
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        //make something to load the user in here
        Menu menu = new Menu();
        GameSave saver = new GameSave("src/Save");

        game.gameLoop(saver,menu);

    }
}
