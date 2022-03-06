import java.util.Observable;
import java.util.Observer;

public class ONewsChannel implements Observer {
    private String news;

    @Override
    public void update(Observable o, Object arg) {
        this.setNews((String) arg);
    }

    public void setNews(String news){
        this.news = news;
    }

    public String getNews() {
        return news;
    }
}
