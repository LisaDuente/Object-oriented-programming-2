import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {

    Control control;
    JFrame frame;
    JPanel panel;
    JTextField inputField;
    JButton randomNumber;
    JButton enterNumber;
    JButton reset;
    JLabel answerField;
    JLabel showTime;
    JLabel showBounds = new JLabel("Guess a number between 1 and 20!");

    public View(Control control){
        this.control = control;
        this.frame = new JFrame();
        this.panel = new JPanel(null);

        this.answerField = new JLabel("Answer");
        this.showTime = new JLabel("Time");
        this.inputField = new JTextField();
        this.randomNumber = new JButton("Play");
        this.enterNumber = new JButton("Enter");
        this.reset = new JButton("Reset");

        this.showBounds.setBounds(50,10,250,25);
        this.answerField.setBounds(50, 50, 100,25);
        this.randomNumber.setBounds(250, 50, 100, 25);
        this.showTime.setBounds(175, 50, 50, 25);
        this.inputField.setBounds(50, 100, 150, 25);
        this.enterNumber.setBounds(250, 100, 100, 25);
        this.reset.setBounds(50, 150, 100, 25);

        //start the timer and randomize a number
        this.enterNumber.addActionListener((e) -> {this.control.setInput(inputField.getText());
            this.inputField.setText("");
            this.control.compareInput();});
        this.randomNumber.addActionListener((e) -> {this.control.ramdomize(); this.control.play(); this.control.updateNumber();});
        this.reset.addActionListener(e -> control.resetModel());

        this.panel.setBounds(0,0,400,250);
        this.panel.setVisible(true);
        this.panel.add(randomNumber);
        this.panel.add(enterNumber);
        this.panel.add(inputField);
        this.panel.add(showTime);
        this.panel.add(answerField);
        this.panel.add(reset);
        this.panel.add(showBounds);

        this.frame.add(panel);
        this.frame.setVisible(true);
        this.frame.setSize(400,250);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "message":
                this.answerField.setText(evt.getNewValue().toString());
                break;
            case "timer":
                this.showTime.setText(evt.getNewValue().toString());
                break;
            default:
                System.out.println("View::propertyChange:Error");
        }
    }
}
