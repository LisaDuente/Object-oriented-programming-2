import java.io.File;

public class User {
    private String name;
    private int win;
    private int loose;

    public User(String name){
        this.name = name;
        this.win = 0;
        this.loose = 0;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getWin() {
        return win;
    }

    public void setLoose(int loose) {
        this.loose = loose;
    }

    public int getLoose() {
        return loose;
    }
}
