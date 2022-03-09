import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View {

    JFrame frame;
    JPanelBackground panel;
    OwnButtonUI button;
    TryButton buttonTry;
    String source;
    File file;
    BufferedImage bg;
    JLabel label;

    public View(){
        label = new JLabel("Hi");
        label.setBounds(200,200,100,25);
        file = new File("src/RPS.bmp");

        try {
            bg = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame = new JFrame();
        panel = new JPanelBackground(bg);
        source = "src/Button.png";
        button = new OwnButtonUI();
        
        buttonTry = new TryButton("src/Button.png");
        buttonTry.setBounds(100,300,100,25);
        buttonTry.setUI(button);
        buttonTry.addActionListener(e -> label.setText("Bye!"));


        panel.setSize(500,400);
        panel.add(buttonTry);
        panel.add(label);
        panel.setLayout(null);

        frame.setSize(500,400);
        frame.setVisible(true);

        frame.add(panel);
    }
}
