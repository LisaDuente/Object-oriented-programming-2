package Exercises;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //UI view = new UI();

        //two threads that operate on the same list, gets out something that looks like encryption if
        //you don't synchronize the variable in Thread.run()
        List<Character> myList = new ArrayList<>();
        String message1 = "Happy Hippo KinderParty";
        String message2 = "Bad Pirate";

        /*Thread thread1 = new Synch(myList,message1);
        Thread thread2 = new Synch(myList,message2);

        thread1.start();
        thread2.start();

        Thread thread3 = new LockThreads(myList,message1);
        Thread thread4 = new LockThreads(myList, message2);

        thread4.start();
        thread3.start();


        //make a daemon thread
        MakeAThreadStopRunnable task = new MakeAThreadStopRunnable();
        Thread threadForDaemon = new Thread(task);

        threadForDaemon.setDaemon(true);
        threadForDaemon.start();
        //if this thread reaches the end of main it stops
        System.out.println("end of main");


        //makes that everything in the ExecutorService runs one after another
        PoolsAndExecutions example = new PoolsAndExecutions();
        //example.startThreadPool();
        //example.startFixedThreadpool();
        example.startCachedThreadpool();

         */
        //try out the Producer-Consumer-Pattern
        ProducerConsumerPattern proCon = new ProducerConsumerPattern();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                proCon.produce();
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                proCon.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}
