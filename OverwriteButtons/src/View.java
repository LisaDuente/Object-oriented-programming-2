import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View {

    JFrame frame;
    JPanelBackground panel;
    OwnButtonUI buttonUI;
    OwnButtonUI buttonUI2;
    TryButton buttonTry;
    String source;
    File file;
    BufferedImage bg;
    JLabel label;
    JButton normalButton;

    public View(){
        normalButton = new JButton("Hello");
        label = new JLabel("Hi");
        label.setBounds(200,200,100,25);
        file = new File("src/FigthingBG.png");

        try {
            bg = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame = new JFrame();
        panel = new JPanelBackground(bg);
        source = "src/customButtonFight.png";

        buttonUI2 = new OwnButtonUI("src/customButtonFight.png","src/customButtonFightPressed.png","src/customButtonFightHover.png");

        buttonUI = new OwnButtonUI("src/customButtonFight.png","src/customButtonFightPressed.png","src/customButtonFightHover.png");

        buttonTry = new TryButton(source);
        buttonTry.setBackground(Color.BLACK);
        buttonTry.setBounds(100,300,100,25);
        buttonTry.setUI(buttonUI);
        System.out.println(buttonTry.getUIClassID());
        buttonTry.setBorder(null);
        buttonTry.setText("Click");
        buttonTry.addActionListener(e -> label.setText("Bye!"));

        normalButton.setBounds(100, 150, 100,25);
        normalButton.setUI(buttonUI2);
        normalButton.setBorder(null);


        panel.setSize(500,400);
        panel.add(buttonTry);
        panel.add(normalButton);
        panel.add(label);
        panel.setLayout(null);

        frame.setSize(500,400);
        frame.setVisible(true);

        frame.add(panel);
    }
}
