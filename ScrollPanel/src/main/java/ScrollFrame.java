import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScrollFrame extends JFrame{
    JScrollPane scrollPane;
    String[] proxy;

    public ScrollFrame(String[] list){
        proxy = list;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,700,700);
        getContentPane().setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10,10,660,660);
        getContentPane().add(scrollPane);

        JPanel borderLayoutPanel = new JPanel();
        scrollPane.setViewportView(borderLayoutPanel);
        borderLayoutPanel.setLayout(new BorderLayout(0,0));

        JPanel columnPanel = new JPanel();
        borderLayoutPanel.add(columnPanel,BorderLayout.NORTH);
        columnPanel.setLayout(new GridLayout(0,1,0,1));
        columnPanel.setBackground(Color.pink);

        for(int i = 0; i<proxy.length; i++){
            JPanel rowPanel = new JPanel();
            rowPanel.setPreferredSize(new Dimension(400, 100));
            columnPanel.add(rowPanel);

            JButton book= new JButton("Book");
            book.setBounds(250,35, 100, 30);
            rowPanel.add(book);

            JLabel label = new JLabel(proxy[i]);
            label.setBounds(50,35,200,30);
            rowPanel.add(label);

            rowPanel.setLayout(null);
            if(i%2==0)
                rowPanel.setBackground(SystemColor.inactiveCaptionBorder);
        }
    }
}
