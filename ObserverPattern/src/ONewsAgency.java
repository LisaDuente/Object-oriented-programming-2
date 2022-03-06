import java.util.Observable;

//because the class extends the Observable class it doesn't need to call the update function in
// observer, everything works with setChanged and notifyObservers
public class ONewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
