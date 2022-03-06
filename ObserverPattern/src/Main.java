public class Main {
    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);
        observable.setNews("bämbelt");
        System.out.println(observer.getNews());

        ONewsAgency observable2 = new ONewsAgency();
        ONewsChannel observer2 = new ONewsChannel();

        observable2.addObserver(observer2);
        observable2.setNews("Gämbelt");
        System.out.println(observer2.getNews());

        //because observer/observable were deprecated you need to use PropertyChangeListener and
        // PropertyChangeSupport classes
        PCLNewsAgency observable3 = new PCLNewsAgency();
        PCLChannel observer3 = new PCLChannel();

        observable3.addPropertyChangeListener(observer3);
        observable3.setNews("Bampf");
        System.out.println(observer3.getNews() + " "+ observer3.getAge());
    }
}
