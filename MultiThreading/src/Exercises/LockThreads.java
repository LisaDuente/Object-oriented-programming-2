package Exercises;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockThreads extends Thread{
    private List<Character> names;
    private String message;
    private static Lock lock = new ReentrantLock();

    //takes the list as an argument because we want many threads to work on the same list
    public LockThreads(List<Character> list, String mes){
        this.names = list;
        this.message = mes;

    }

    @Override
    public void run() {
        //locks the thread, needs to be unlocked in the same context
        lock.lock();
        try{
            for (int i = 0; i < message.length(); i++) {
                names.add(message.charAt(i));

                    Thread.sleep(50);
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        //this runs even if there is an error message
        }finally{
            //you need to unlock for the other threads
            lock.unlock();
        }
        System.out.println("charlist = " + this.names);
            }

}



