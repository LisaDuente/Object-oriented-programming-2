import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model{
    private int currentNumber;
    private String currentMessage;
    PropertyChangeSupport support;

    public Model(){
        this.currentNumber = 0;
        this.currentMessage = "";
        this.support = new PropertyChangeSupport(this);
    }

    public void addPCL(PropertyChangeListener pcl){
        this.support.addPropertyChangeListener(pcl);
    }

    public void setCurrentNumber(int currentNumber) {
        support.firePropertyChange("currentNumber",this.currentNumber,currentNumber);
        this.currentNumber = currentNumber;
    }

    public void setCurrentMessage(String currentMessage) {
        support.firePropertyChange("currentMessage",this.currentMessage,currentMessage);
        this.currentMessage = currentMessage;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }
}
