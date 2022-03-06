package RockPaperScissor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class View implements PropertyChangeListener {

    Controller control;
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
    JLabel loadStatus;
    JLabel computer = new JLabel("computer");
    JLabel you;
    JLabel userInput;
    JLabel computerInput;
    //images
    ImageIcon background;
    Image bg;
    ImageIcon scr;
    ImageIcon rck;
    ImageIcon ppr;
    ImageIcon nope;
    /* TO DO

        - something is wrong with the save and load for the database!!!

        - swap the button names in gamePanel to pictures (scr, ppr, rck)
        - make a cool background
        - erase all methods and classes that are no longer used
        - some funny animations for computer's choice and your own choice
        - look into CSS to see if the frame could look better
        - save this as an executable
     */


    public View(String text, Controller control){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.control = control;
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
        this.nope = new ImageIcon("src/RockPaperScissor/TryBackgroundItch.png");

    //initiate labels
        head = new JLabel("Welcome to Rock Paper Scissors!");
        score = new JLabel("Here is your game status");
        loadStatus = new JLabel("No Player");
        you = new JLabel("No Player");
        computerInput = new JLabel(nope);
        userInput = new JLabel(nope);

    //initiate lists
        model = new DefaultListModel<>();
        fillList();
        list = new JList<>(model);
        scroll = new JScrollPane(list);

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

        //define scroll panel
        scroll.createHorizontalScrollBar();
        scroll.setBounds(50,50,375,250);

        load.setBounds(100,325,75,25);
        loadStatus.setBounds(50,10,325,25);
        back1.setBounds (300, 325, 75,25);
        back1.addActionListener(e -> getBack());

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.loadUser(list.getSelectedValue());
                loadStatus.setText(list.getSelectedValue());
                you.setText(list.getSelectedValue());
            }
        });

    //define game panel
        panelGame.setBounds(0,0,500,400);
        panelGame.setBackground(Color.LIGHT_GRAY);
        panelGame.setVisible(false);

        rock.setBounds(50,300, 75,25);
        paper.setBounds(150,300,75,25);
        scissors.setBounds(250,300,75,25);
        back.setBounds (350, 300, 75,25);
        score.setBounds(150,25,200,25);
        you.setBounds(50, 60, 100, 25);
        computer.setBounds(350, 60, 100, 25);
        computerInput.setBounds(350, 100, 48,48);
        userInput.setBounds(50, 100, 48,48);


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getBack();
                control.resetGame();
            }
        });
        rock.addActionListener(e -> control.playGame("rock"));
        scissors.addActionListener(e -> control.playGame("scissors"));
        paper.addActionListener(e -> control.playGame("paper"));


    //add to panels
        panelGame.add(rock);
        panelGame.add(paper);
        panelGame.add(scissors);
        panelGame.add(back);
        panelGame.add(score);
        panelGame.add(you);
        panelGame.add(computer);
        panelGame.add(computerInput);
        panelGame.add(userInput);

        panelLoad.add(load);
        panelLoad.add(back1);
        panelLoad.add(scroll);
        panelLoad.add(loadStatus);

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

    public void fillList(){
        int i = 0;
        HashMap<String,String> map = control.getSaver().getMap();
        for(String key : map.keySet()){
            model.add(i,key);
            i++;
        }
    }

    public void setScore(String s) {
        this.score.setText(s);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "input":
                //set a text for a label or a picture in playPanel
                if(evt.getNewValue().equals("scissors")){

                }else if(evt.getNewValue().equals("rock")){

                }else if(evt.getNewValue().equals("paper")){

                }else{

                }
                break;
            case "message":
                score.setText(evt.getNewValue().toString());
                break;
            case "inputComputer":
                //set a text to know what the computer did or a picture in playPanel
                break;
            case "user":
                //update statistics from user to display in playPanel?
                break;
            //here needs to be everything that could change in the model, like computer output, ect
        }
    }

    public DefaultListModel<String> getModel() {
        return model;
    }
}
