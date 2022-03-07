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
        new Thread(() -> {
            try{
                Thread.sleep(21000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            if(this.input == this.model.getNumber()){
                this.model.setMessage("You won!");
            }else{
                this.model.setMessage("You lost!");
            }

        }).start();
    }

    public void updateNumber(){
        new Thread(() -> {
            while(model.getTimer()>0){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                this.model.setTimer(model.getTimer()-1);
            }
        }).start();
    }

    public void compareInput(){
        if(this.input == this.model.getNumber()){
            this.model.setMessage("Right!");
        } else if(this.input > this.model.getNumber()){
            this.model.setMessage("Too high!");
        }else if(this.input < this.model.getNumber()){
            this.model.setMessage("Too low!");
        }
    }

    public void setInput(String input) {
        this.input = Integer.parseInt(input);
    }

    public void resetModel(){
        this.model.setTimer(20);
        this.model.setNumber(0);
        this.model.setMessage("Answer");
    }
}
