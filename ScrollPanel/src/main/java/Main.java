import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] testList = {"Batman Movie", "Spiderman", "Disneys Frozen", "The Avengers", "Endgame", "Hanni und Nanni","Digimon", "Pokemon - The Movie", "Erkan super Boss", "Igor working hard", "Toros learning fast"};
        JFrame test = new ScrollFrame(testList);
        test.setVisible(true);
    }
}
