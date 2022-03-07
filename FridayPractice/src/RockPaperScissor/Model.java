package RockPaperScissor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    PropertyChangeSupport support;
    private User user;
    private GameEngine game;
    private GameSaveDB saver;
    private String currentUserName;
    private String error;
    private String message;
    private String inputUser;
    private String inputComputer;

    public Model(){
        this.game = new GameEngine();
        this.saver = new GameSaveDB();
        this.support = new PropertyChangeSupport(this);
    }

    public void addPcl(PropertyChangeListener pcl){
        support.addPropertyChangeListener(pcl);
    }

    public void removePcl(PropertyChangeListener pcl){
        support.removePropertyChangeListener(pcl);
    }

    public void setInputUser(String input) {
        support.firePropertyChange("input", this.inputUser, input);
        this.inputUser = input;
    }

    public void setError(String error) {
        support.firePropertyChange("error", this.error, error);
        this.error = error;
    }

    public void setCurrentUserName(String currentUserName) {
        support.firePropertyChange("currentUserName", this.currentUserName, currentUserName);
        this.currentUserName = currentUserName;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setMessage(String message) {
        support.firePropertyChange("message",this.message,message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setUser(User user) {
        support.firePropertyChange("user", this.user, user);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setInputComputer(String inputComputer) {
        support.firePropertyChange("inputComputer", this.inputComputer,inputComputer);
        this.inputComputer = inputComputer;
    }

    public GameEngine getGame() {
        return game;
    }

    public GameSaveDB getSaver() {
        return saver;
    }

}
