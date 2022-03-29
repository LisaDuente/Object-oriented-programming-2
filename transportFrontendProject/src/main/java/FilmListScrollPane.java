import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class FilmListScrollPane extends JScrollPane {
    MovieDetailsPanel movieDetails;
    private Movie currentMovie = new Movie();
    private String currentMovieId = "";
    ConnectionManager connect = new ConnectionManager();
    Gson gson = new Gson();

    //TODO: Add an Image Icon and a Link from a website to this panel
    public FilmListScrollPane(MovieDetailsPanel movieDetails){
        this.movieDetails = movieDetails;
        //gets the list of movies as a JSON string
        String movieListString = connect.sendUrlToDownloadAllMovies();
        //transfers the JSON in an ArrayList with Movies in JSON format
        ArrayList<Movie> movieListFromBackend = gson.fromJson(movieListString,new TypeToken<ArrayList<JsonObject>>(){}.getType());
        this.setBounds(50,20,900,700);

        JPanel borderLayoutPanel = new JPanel();
        this.setViewportView(borderLayoutPanel);
        borderLayoutPanel.setLayout(new BorderLayout(0,0));

        JPanel columnPanel = new JPanel();
        borderLayoutPanel.add(columnPanel,BorderLayout.NORTH);
        columnPanel.setLayout(new GridLayout(0,1,0,1));
        columnPanel.setBackground(Color.DARK_GRAY);


        for(int i = 0; i<movieListFromBackend.size(); i++){
            //converts the json objects in the list to actual movie objects
            String movieString = String.valueOf(movieListFromBackend.get(i));
            this.currentMovie = gson.fromJson(movieString, Movie.class);
            if((boolean)this.currentMovie.isAvailable()) {

                JPanel rowPanel = new JPanel();
                rowPanel.setPreferredSize(new Dimension(600, 100));
                columnPanel.add(rowPanel);
                //TODO: needs to return the movie Id for the next panel somehow
                JButton book = new JButton("Book");
                book.setBounds(550, 35, 100, 30);
                rowPanel.add(book);

                //to get the ID
                JLabel id = new JLabel(String.valueOf(this.currentMovie.getId()));
                id.setVisible(false);
                book.addActionListener((e) -> {
                    //TODO: look up the backend if its up to date then it should be sending a json string here

                    this.setVisible(false);
                    String movieAsString = connect.sendUrlToDownloadMovieById(Integer.parseInt(id.getText()));
                    System.out.println(" Here should be a JSON String: "+movieAsString);
                    this.currentMovie = gson.fromJson(movieAsString,Movie.class);

                    this.movieDetails.setCurrentMovie(this.currentMovie);
                    this.movieDetails.updatePanel();
                    this.movieDetails.setVisible(true);
                    System.out.println(this.currentMovie.toString());
                });

                //change this
                JLabel movieTitle = new JLabel(this.currentMovie.getName());
                movieTitle.setBounds(150, 10, 200, 30);
                rowPanel.add(movieTitle);

                JLabel movieGenre = new JLabel(this.currentMovie.getGenre());
                movieGenre.setBounds(150, 35, 200, 30);
                rowPanel.add(movieGenre);

                JLabel movieDuration = new JLabel(this.currentMovie.getDuration());
                movieDuration.setBounds(150, 50, 200, 30);
                rowPanel.add(movieDuration);

                JTextArea shortMovieDescription = new JTextArea(this.currentMovie.getShortDescription());
                shortMovieDescription.setBounds(350, 10, 200, 100);
                shortMovieDescription.setEditable(false);
                shortMovieDescription.setLineWrap(true);

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

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }
}

