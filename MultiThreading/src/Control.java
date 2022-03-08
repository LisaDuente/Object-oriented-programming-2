import java.util.Random;

public class Control {
    private Model model;
    private int input;

    public Control(Model model){
        this.model = model;
    }

    //randomizes a number between 1 and 20 after 20 seconds
    public void ramdomize() {
        Random random = new Random();
        this.model.setNumber(random.nextInt(1, 21));
    }
    public void play(){
        this.model.startThreads();
    }



    public void compareInput(){
        if(this.model.getInput() == this.model.getNumber()){
            this.model.setMessage("Right!");
        } else if(this.model.getInput() > this.model.getNumber()){
            this.model.setMessage("Too high!");
        }else if(this.model.getInput() < this.model.getNumber()){
            this.model.setMessage("Too low!");
        }
    }

    public void setInput(String input) {
        this.model.setInput(Integer.parseInt(input));
    }

    public void resetModel(){
        this.model.setTimer(20);
        this.model.setNumber(0);
        this.model.setMessage("Answer");
    }
}
