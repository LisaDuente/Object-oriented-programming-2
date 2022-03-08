package Exercises;

public class MakeAThreadStopRunnable implements Runnable{
    private boolean shouldExit;

    public MakeAThreadStopRunnable(){
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName() + " is doing some work...");
            try{
                Thread.sleep(2000);
                if(shouldExit){
                    break;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }
}
