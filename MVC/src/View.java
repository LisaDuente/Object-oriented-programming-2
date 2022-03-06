import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {

    JFrame frame;
    JPanel panel;
    JButton plus;
    JButton minus;
    JLabel number;
    JLabel message;
    Controller control;


    public View(Controller control){
        this.control = control;
        this.frame = new JFrame("Number Ticker");
        this.panel = new JPanel(null);
        this.plus = new JButton("+");
        this.minus = new JButton("-");
        this.number = new JLabel("0");
        this.message = new JLabel("null");

        this.panel.setBounds(0,0,300,200);
        this.panel.setVisible(true);
        this.panel.add(this.plus);
        this.panel.add(this.minus);
        this.panel.add(this.number);
        this.panel.add(this.message);

        this.plus.setBounds(50,100,50,25);
        this.minus.setBounds(175,100,50,25);
        this.number.setBounds(125,50,50,25);
        this.message.setBounds(50,50,200,25);

        this.plus.addActionListener(e -> control.increase());
        this.minus.addActionListener(e -> control.decrease());

        this.frame.setSize(300,200);
        this.frame.setResizable(false);
        this.frame.add(panel);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
    public void update(){
        this.number.setText(String.valueOf(pclPlus.getValue()));
    }

     */

    public JLabel getNumber() {
        return number;
    }

    //https://docs.oracle.com/javase/7/docs/api/java/beans/PropertyChangeEvent.html
    //event is made out of the property name, the old value and the new value. There are methods to get everything back from the event (name, values)
    //that's why you can use a switch case to set different values depending on the property name
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "currentMessage" -> this.message.setText((String) evt.getNewValue());
            case "currentNumber" -> this.number.setText(String.valueOf((int)evt.getNewValue()));
            default -> System.out.println("View::propertyChange:error");
        }
    }
}
