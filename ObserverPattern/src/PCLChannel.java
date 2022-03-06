import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PCLChannel implements PropertyChangeListener {
    private String news;


    public void propertyChange(PropertyChangeEvent e){
        this.setNews((String) e.getNewValue());
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }

}
