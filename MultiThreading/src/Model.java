import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    private int number;
    private String message;
    private int timer;
    PropertyChangeSupport support;

    public Model(){
        this.timer = 20;
        this.support = new PropertyChangeSupport(this);
    }

    public void addPCL(PropertyChangeListener pcl){
        this.support.addPropertyChangeListener(pcl);
    }

    public void removePCL(PropertyChangeListener pcl){
        this.support.removePropertyChangeListener(pcl);
    }

    public void setMessage(String message) {
        support.firePropertyChange("message", this.message, message);
        this.message = message;
    }

    public void setNumber(int number) {
        //support.firePropertyChange("number", this.number, number);
        this.number = number;
    }

    public void setTimer(int number){
        support.firePropertyChange("timer", this.timer, number);
        this.timer = number;
    }

    public int getTimer() {
        return timer;
    }

    public int getNumber() {
        return number;
    }
}
