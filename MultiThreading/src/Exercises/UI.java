package Exercises;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JFrame frame;
    private JButton button;
    private JTextField text;

    public UI(){
        this.frame = new JFrame("UI");
        this.button = new JButton("calculate");
        this.text = new JTextField();

        text.setBounds(100,100,200,50);
        button.setBounds(150,200,100,50);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long l = Long.parseLong(text.getText());
                long sum = 0L;
                for(int i = 0; i<=l; i++){
                    sum += i;
                }
                JOptionPane.showMessageDialog(text, "Result is: " + sum);
            }
        });

        frame.add(button);
        frame.add(text);

        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
