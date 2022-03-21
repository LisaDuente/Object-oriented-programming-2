import javax.swing.*;

//for this program to run you need to run a RESTful backend program at the same time

public class GUI extends JFrame {
    private JTextField nameInput;
    private JTextField num1Input;
    private JTextField num2Input;
    private JButton enterName;
    private JButton enterNumbers;
    private JLabel resultName;
    private JLabel resultNumbers;
    private JLabel plus;
    private ConnectionManager manager;

    public GUI(){
        this.manager = new ConnectionManager();

    //define output for hello method
        this.nameInput = new JTextField();
        this.enterName = new JButton("Enter");
        this.resultName = new JLabel("Empty");

        this.nameInput.setBounds(50,50,115,25);
        this.enterName.setBounds(170,50,75,25);
        this.resultName.setBounds(75,75,200,25);

        this.enterName.addActionListener((e) -> {
            //its better to do this in a new thread so that the gui doesnt freeze
            new Thread(()-> {
                String text = manager.sendRequest("hello/?name="+nameInput.getText());
                nameInput.setText("");
                resultName.setText(text);
            }).start();
        });


    //define output for calculate
        this.num1Input = new JTextField();
        this.num2Input = new JTextField();
        this.enterNumbers = new JButton("Enter");
        this.resultNumbers = new JLabel("Empty");
        this.plus = new JLabel("+");

        this.num1Input.setBounds(50,175,50,25);
        this.num2Input.setBounds(115,175,50,25);
        this.plus.setBounds(103,175,20,25);
        this.enterNumbers.setBounds(170,175,75,25);
        this.resultNumbers.setBounds(75,200,200,25);

        this.enterNumbers.addActionListener((e) -> {
            new Thread(() -> {
                String text = manager.sendRequest("calculate/?num1="
                        +num1Input.getText()
                        +"&num2="+num2Input.getText());
                num2Input.setText("");
                num1Input.setText("");
                resultNumbers.setText(text);
            }).start();
        });

    //add to the frame
        this.add(num1Input);
        this.add(num2Input);
        this.add(plus);
        this.add(enterNumbers);
        this.add(resultNumbers);
        this.add(enterName);
        this.add(nameInput);
        this.add(resultName);

        this.setSize(300,300);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
