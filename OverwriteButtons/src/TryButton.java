import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TryButton extends JButton {
    BufferedImage button;
    File sourceButton;

    public TryButton(String path) {
        sourceButton = new File(path);
        try {
            button = ImageIO.read(sourceButton);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(button, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(button.getWidth(), button.getHeight());
    }
}
