package Exercises;

public class Threads {
    Thread innerThread;
    public Threads(){
        //how to make new threads
        this.innerThread = new Thread();
    }

    //do it with lambdas
    public void threadsAndForLoops1(){
        new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("I'm the first loop!");
            }
        }).start();

        new Thread( () -> {
        for(int i = 0; i < 10; i++){
            try{
                //lets the thread wait a specific amount of time
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("I'm the second loop!");
        }
        }).start();

        new Thread( () -> {
        for(int i = 0; i < 10; i++){
            System.out.println("I'm the third loop!");
        }
        }).start();
    }

    //do it like an oldtimer
    public void threadsAndForLoops2(){
        Thread one = new Thread(new SingleThread("I'm first!"));
        Thread two = new Thread(new SingleThread("I'm second!"));
        Thread three = new Thread(new SingleThread("I'm third"));

        one.start();
        two.start();
        three.start();

        System.out.println("first: " + one.getState());

        try{
            //waits until join is ready, if there is a number in ms the program waits this time
            //before it runs the rest of the program
            one.join(1000);
            two.join(1000);
            three.join(1500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        //this stops all processes and threads, it doesn't print out anything because the
        // threads wait 500ms before they print out something
        System.exit(0);
    }

    //make a new thread with the second constructor in SingleThread
    public void threadsAndForLoops3(){
        new Thread(new SingleThread()).start();
        new Thread(new SingleThread("Not the Spider")).start();
    }

    public static void main(String[] args) {
        Threads th = new Threads();

        System.out.println(Thread.currentThread().getName());
        System.out.println(th.innerThread.getName());

        //change name
        th.innerThread.setName("Lisa");
        System.out.println(th.innerThread.getName());

        //get state (States can be NEW, RUNNABLE, WAITING)
        System.out.println(th.innerThread.getState());

        //Thread.stop() is no good to use because it can lead to memory problems
        //that's why we use Thread.join()


        //use threads to operate different for-loops, as you can see it prints out different patterns
        //th.threadsAndForLoops1();
        th.threadsAndForLoops2();
        //th.threadsAndForLoops3();
    }

}
