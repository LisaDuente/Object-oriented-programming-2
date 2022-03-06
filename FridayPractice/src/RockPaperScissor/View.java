package RockPaperScissor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class View {

    Model modelClass;
    //frame and panel
    JFrame frame;
    JPanel panelMenu;
    JPanel panelGame;
    JPanel panelLoad;
    JPanelBackground test;
    //buttons
    JButton menuLoad;
    JButton menuPlay;
    JButton menuClose;
    JButton rock;
    JButton paper;
    JButton scissors;
    JButton load;
    JButton back;
    JButton back1;
    //lists
    JList<String> list;
    DefaultListModel<String> model;
    JScrollPane scroll;
    //labels
    JLabel head;
    JLabel score;
    //images
    ImageIcon background;
    Image bg;

    /* TO DO
        - couple button to input (scissor button = scissor input)
        - fill player names in List, load should then load the chosen player
        - look up how the rows in a list are used
        - swap the button names in gamePanel to pictures
        - make a cool background
        - some funny animations for computer's choice and your own choice
        - look into CSS to see if the frame could look better
        - save this as an executable
     */


    public View(String text){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //control = new Controller();
        frame = new JFrame(text);

    //initiate panels
        panelMenu = new JPanel(null);
        panelLoad = new JPanel(null);
        panelGame = new JPanel(null);

    //initiate buttons
        menuClose = new JButton("Close");
        menuLoad = new JButton("Load");
        menuPlay = new JButton("Play");
        back = new JButton("Back");
        back1 = new JButton("Back");
        load = new JButton("Load");
        rock = new JButton("Rock");
        paper = new JButton("Paper");
        scissors = new JButton("Scissors");

    //initiate images
        this.background = new ImageIcon("src/RockPaperScissor/RPS.bmp");
        this.bg = background.getImage();

    //initiate labels
        head = new JLabel("Welcome to Rock Paper Scissors!");
        score = new JLabel("Here is your game status");

    //initiate lists
        model = new DefaultListModel<>();
        fillList();
        list = new JList<>(model);
        scroll = new JScrollPane(list);

    //define scroll panel
        scroll.createHorizontalScrollBar();
        scroll.setBounds(50,50,375,250);

    //define menu panel
        panelMenu.setBounds(0,0,500,400);
        panelMenu.setBackground(Color.LIGHT_GRAY);

    //define menu panel
        head.setBounds(150,25,200,25);
        menuLoad.setBounds(100,300, 75,25);
        menuPlay.setBounds(200,300,75,25);
        menuClose.setBounds(300,300,75,25);

        menuLoad.addActionListener(e -> changeToLoad());
        menuPlay.addActionListener(e -> changeToGame());
        menuClose.addActionListener(e -> endGame() );

    //define load panel
        panelLoad.setBounds(0,0,500,400);
        panelLoad.setBackground(Color.LIGHT_GRAY);
        panelLoad.setVisible(false);

        load.setBounds(100,325,75,25);
        back1.setBounds (300, 325, 75,25);
        back1.addActionListener(e -> getBack());

    //define game panel
        panelGame.setBounds(0,0,500,400);
        panelGame.setBackground(Color.LIGHT_GRAY);
        panelGame.setVisible(false);

        rock.setBounds(50,300, 75,25);
        paper.setBounds(150,300,75,25);
        scissors.setBounds(250,300,75,25);
        back.setBounds (350, 300, 75,25);
        score.setBounds(150,25,200,25);

        back.addActionListener(e -> getBack());


    //add to panels
        panelGame.add(rock);
        panelGame.add(paper);
        panelGame.add(scissors);
        panelGame.add(back);
        panelGame.add(score);

        panelLoad.add(load);
        panelLoad.add(back1);
        panelLoad.add(scroll);

        panelMenu.add(menuLoad);
        panelMenu.add(menuPlay);
        panelMenu.add(menuClose);
        panelMenu.add(head);

    //add to frame
        frame.add(panelMenu);
        frame.add(panelLoad);
        frame.add(panelGame);

        frame.setSize(500,400);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void changeToLoad(){
        panelMenu.setVisible(false);
        panelLoad.setVisible(true);
    }

    public void changeToGame(){
        panelMenu.setVisible(false);
        panelGame.setVisible(true);
    }

    public void getBack(){
        panelMenu.setVisible(true);
        panelLoad.setVisible(false);
        panelGame.setVisible(false);
    }

    public void endGame(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        System.exit(0);
    }

    public void fillList(/*HashMap map*/){
        //take all information from the save file and load it in here
        for(int i = 0; i<30;i++){
            model.add(i,"test" + i);
        }
    }

    public void setScore(String s) {
        this.score.setText(s);
    }
}
