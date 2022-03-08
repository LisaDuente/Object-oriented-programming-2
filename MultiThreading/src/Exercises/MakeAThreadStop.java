package Exercises;

public class MakeAThreadStop {
    public static void main(String[] args) {
        //initiate the runnable
        //you don't want to have a lambda here because you need to set a flag to stop the thread
        MakeAThreadStopRunnable thing = new MakeAThreadStopRunnable();

        //put it inside the thread to have a starting point and a task
        Thread thread = new Thread(thing);

        //take a look at the state
        System.out.println(thread.getState());

        //starts the thread
        thread.start();

        //take a look at the state
        System.out.println(thread.getState());

        //wait a little
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        //set the flag to true to break the loop and stop the thread
        thing.setShouldExit(true);

        //wait
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        //take a look at the state
        System.out.println(thread.getState());

    }
}
