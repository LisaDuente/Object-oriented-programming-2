import javax.swing.*;
import java.awt.*;

public class BackPanel extends JPanel {
    JButton backToFront;
    String state = "start";
    public BackPanel(FilmListScrollPane scrollPane, startPagePanel start,MovieDetailsPanel details){
        this.setSize(700,200);
        this.setLayout(new BorderLayout());


        this.backToFront = new JButton("Back");
        this.backToFront.setSize(100,25);
        this.add(backToFront,BorderLayout.EAST);

        this.backToFront.addActionListener((e) -> {
            switch(this.state){
                case "start":
                    break;
                case "scroll":
                    start.setVisible(true);
                    scrollPane.setVisible(false);
                    details.setVisible(false);
                    this.state = "start";
                    break;
                case "details":
                    start.setVisible(false);
                    scrollPane.setVisible(true);
                    details.setVisible(false);
                    this.state = "scroll";
                    break;
            }
            ;});
        this.setVisible(true);
    }

    public void setState(String state) {
        this.state = state;
    }
}
