import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class ScrollFrame extends JScrollPane{
    JScrollPane scrollPane;
    ArrayList<Map<String,Object>> proxy;
    Map<String, Object> currentMovie;

    public ScrollFrame(ArrayList<Map<String,Object>> list){
        proxy = list;
        setBounds(100,100,700,700);

        //scrollPane = new JScrollPane();
        this.setBounds(10,10,660,660);


        JPanel borderLayoutPanel = new JPanel();
        this.setViewportView(borderLayoutPanel);
        borderLayoutPanel.setLayout(new BorderLayout(0,0));

        JPanel columnPanel = new JPanel();
        borderLayoutPanel.add(columnPanel,BorderLayout.NORTH);
        columnPanel.setLayout(new GridLayout(0,1,0,1));
        columnPanel.setBackground(Color.DARK_GRAY);

        /*
        public class Movie {

    private int id;
    private String name;
    private String genre;
    private String duration;
    private String movieDescription;
    private boolean isAvailable;
         */

        for(int i = 0; i<proxy.size(); i++){
            this.currentMovie = proxy.get(i);
            if((boolean)this.currentMovie.get("isAvailable")) {

                JPanel rowPanel = new JPanel();
                rowPanel.setPreferredSize(new Dimension(400, 100));
                columnPanel.add(rowPanel);

                //change this
                JLabel movieTitle = new JLabel(String.valueOf(this.currentMovie.get("name")));
                movieTitle.setBounds(150, 10, 200, 30);
                rowPanel.add(movieTitle);

                JLabel movieGenre = new JLabel(String.valueOf(this.currentMovie.get("genre")));
                movieGenre.setBounds(150, 35, 200, 30);
                rowPanel.add(movieGenre);

                JLabel movieDuration = new JLabel(String.valueOf(this.currentMovie.get("duration")));
                movieDuration.setBounds(150, 50, 200, 30);
                rowPanel.add(movieDuration);

                JTextArea shortMovieDescription = new JTextArea((String.valueOf(this.currentMovie.get("shortDescription"))));
                shortMovieDescription.setBounds(350, 10, 200, 100);
                shortMovieDescription.setEditable(false);
                shortMovieDescription.setLineWrap(true);

                JButton book= new JButton("Book");
                book.setBounds(250,35, 100, 30);
                book.setFocusPainted(false);
                rowPanel.add(book);


                rowPanel.add(shortMovieDescription);

                rowPanel.setLayout(null);
                if (i % 2 == 0) {
                    rowPanel.setBackground(SystemColor.pink);
                    shortMovieDescription.setBackground(SystemColor.pink);
                }else{
                    shortMovieDescription.setBackground(SystemColor.WHITE);
                    rowPanel.setBackground(SystemColor.WHITE);
                }
            }
        }
    }
}