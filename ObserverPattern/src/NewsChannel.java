public class NewsChannel implements Channel{
    private String news;

    @Override
    public void update(Object o) {
        this.setNews((String) o);
    }

    public void setNews( String news){
        this.news = news;
    }

    public String getNews() {
        return news;
    }
}
