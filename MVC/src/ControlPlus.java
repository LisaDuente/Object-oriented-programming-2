import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ControlPlus implements PropertyChangeListener {
    int value = 0;

    public void propertyChange(PropertyChangeEvent e){

            this.setValue((int)e.getNewValue()) ;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
