package Exercises;

import java.util.LinkedList;

//this is the object which will be used in different threads
public class ProducerConsumerPattern {

    LinkedList<Integer> myList = new LinkedList<>();
    //this many things should be in the buffer/list
    int cap = 3;

    //produces until the cap is reached
    public void produce(){
        int value = 0;
        //should run infinitely
        while(true) {
            //we can lock the whole thing while synchronizing
            synchronized (this) {
                //wait until something got consumed
                while (myList.size() == cap) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Has has produced: " + value);
                myList.add(value);
                value++;

                notify();
                //just to see the print
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //consumes everything in our buffer/list
    public void consume(){
        while(true){
            synchronized (this) {
                //wait until something was produced
                while (myList.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int value = myList.removeFirst();
                System.out.println("Consumed: " + value);
                notify();
                //just to see the print
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
