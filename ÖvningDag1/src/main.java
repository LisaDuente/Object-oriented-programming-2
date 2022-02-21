public class main {
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        //make something to load the user in here
        User user1 = new User();
        user1.chooseName();
        GameSave saver = new GameSave("src/Save");

        game.welcome();
        game.playGame(user1);
        user1.showStats();

        saver.saveUserInArray(user1);
        saver.readFromFile();
        saver.saveToFile();

    }
}
