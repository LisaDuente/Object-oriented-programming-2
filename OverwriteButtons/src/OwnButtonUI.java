import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OwnButtonUI extends BasicButtonUI {
    BufferedImage button;
    BufferedImage buttonPressed;
    File sourceButton;
    File sourceButtonPressed;

    public OwnButtonUI(){
        sourceButton = new File("src/Button.png");
        sourceButtonPressed = new File("src/ButtonPressed.png");
        try {
            button = ImageIO.read(sourceButton);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            buttonPressed = ImageIO.read(sourceButtonPressed);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void paint(Graphics g, JComponent c) {
             super.paint(g, c);
        g.drawImage(button, 0, 0, null);
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        super.paintButtonPressed(g, b);
        g.drawImage(buttonPressed, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(button.getHeight(), button.getWidth());
    }
}
