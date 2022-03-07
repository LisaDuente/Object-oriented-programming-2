package Exercises;

public class SingleThread implements Runnable{
    private String message;

    public SingleThread(String mes){
        this.message = mes;
    }

    public SingleThread(){
        this.message = "Most animals have more legs than eyes!";
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try{
                //lets the thread wait a specific amount of time
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(this.message);
        }
    }
}
