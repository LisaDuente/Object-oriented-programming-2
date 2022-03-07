import java.util.Random;

public class Control {
    private Model model;
    private int input;
    private Thread th;
    private Thread th2;

    public Control(Model model){
        this.model = model;
        this.th = th = new Thread(() -> {
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
        });
        this.th2 = new Thread(() -> {
            while(model.getTimer()>0){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                this.model.setTimer(model.getTimer()-1);
            }
        });
    }

    //randomizes a number between 1 and 20 after 20 seconds
    public void ramdomize() {
        Random random = new Random();
        this.model.setNumber(random.nextInt(1, 21));
    }
    public void play(){
        th.start();
    }

    //close the thread when a certain condition is met?
    public void check(){
        new Thread(()-> {
            while(th.isAlive()){
                if(this.model.getMessage().equals("Right!")){
                    try {
                        th.join(1);
                        th2.join(1);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void updateNumber(){
        th2.start();
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
