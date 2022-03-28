import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    startPagePanel startPage;
    FilmListScrollPane movieList;
    MovieDetailsPanel movieDetails;
    BackPanel backPanel;
    //Movie currentMovie;
    //ArrayList<Movie> movieArrayList;

    public MainFrame(){
        //DEFINE FRAME
        this.setSize(1000,800);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //INITIALIZE
        this.startPage = new startPagePanel();
        this.movieDetails = new MovieDetailsPanel();
        this.movieList = new FilmListScrollPane(this.movieDetails);
        this.backPanel = new BackPanel(this.movieList,this.startPage,this.movieDetails);

        //ADD TO FRAME
        this.add(this.movieList,BorderLayout.CENTER);
        this.add(this.backPanel, BorderLayout.SOUTH);
        this.add(this.movieDetails, BorderLayout.CENTER);
        this.add(this.startPage,BorderLayout.CENTER);

        //SET VISIBILITY
        //TODO: startPage doesn't work and i don't know why
        this.startPage.setVisible(false);
        this.movieList.setVisible(true);
        this.backPanel.setVisible(true);
        this.movieDetails.setVisible(false);
        this.setVisible(true);
    }
}