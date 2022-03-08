import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    private int number;
    private String message;
    private int timer;
    private Thread thTimer;
    private int input;
    PropertyChangeSupport support;

    public Model(){
        this.message = "";
        this.timer = 20;
        this.support = new PropertyChangeSupport(this);
        this.thTimer =  new Thread(() -> {
            while(this.timer > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setTimer(this.timer - 1);
                if (this.message.equals("Right!")) {
                    break;
                }
            }
            if(this.input == this.number){
                setMessage("You won!");
            }else{
                setMessage("You lost!");
            }
        });
    }

    public void startThreads(){
        thTimer.start();
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

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getTimer() {
        return timer;
    }

    public int getNumber() {
        return number;
    }

    public Thread getThTimer() {
        return thTimer;
    }
}
