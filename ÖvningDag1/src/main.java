public class main {
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        //make something to load the user in here
        User user1 = new User("lisa");
        game.playGame(user1);
        System.out.println("Wins: " + user1.getWin()+" | Lost: "+user1.getLoose());

    }
}
