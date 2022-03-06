package RockPaperScissor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JPanelBackground extends JPanel {

    private Image background;

    public JPanelBackground(String path){
        try{
            this.background = ImageIO.read(new File(path));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
    }
}
