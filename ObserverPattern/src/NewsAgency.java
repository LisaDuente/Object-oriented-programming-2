import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private String news;
    //list of observers
    private List<Channel> channels = new ArrayList<>();

    public void addObserver (Channel channel){
        this.channels.add(channel);
    }

    public void removeObserver(Channel channel){
        this.channels.remove(channel);
    }

    public void setNews( String news){
        //every time we change the string, all strings in the channels will be changed
        //to the same string as in the news agency
        this.news = news;
        for(Channel channel : this.channels){
            channel.update(this.news);
        }
    }
}
