package Exercises;

//you need a gui to show this timer
public class MakeTimer {
    String timer;
    boolean shouldExit;

    public MakeTimer(String time){
        this.timer = time;
    }

    public void startTimer(){
        new Thread(() -> {
            double startTime = System.currentTimeMillis();  // get the systems time
            double stopTime = startTime + 10_000.0;         //10 seconds

            while(System.currentTimeMillis() <= stopTime){
                timer = String.valueOf((System.currentTimeMillis()-startTime)/1000); //show each second a different time
                System.out.println(timer);
                //to stop a thread you use a flag and break | .stop method is deprecated and should not be used
                if(shouldExit){
                    break;
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        MakeTimer timer = new MakeTimer("empty");
        timer.startTimer();
    }
}
