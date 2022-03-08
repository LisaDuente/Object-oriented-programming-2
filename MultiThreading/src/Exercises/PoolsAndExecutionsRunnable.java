package Exercises;

public class PoolsAndExecutionsRunnable implements Runnable{
    private long createTimer;
    private String taskName;

    public PoolsAndExecutionsRunnable(String task){
        this.taskName = task;
        //gets the time
        this.createTimer = System.currentTimeMillis();

    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        long waitedTime = System.currentTimeMillis()-createTimer;
        System.out.println(taskName + " is doing stuff with "+ currentThread + ". Waited for " + waitedTime);

        try {
            Thread.sleep(3000);
            System.out.println(taskName + " finished. Releasing "+ currentThread.getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
