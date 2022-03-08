package Exercises;

import java.util.List;

public class Synch extends Thread{
    private List<Character> names;
    private String message;

    //takes the list as an argument because we want many threads to work on the same list
    public Synch(List<Character> list, String mes){
        this.names = list;
        this.message = mes;

    }

    @Override
    public void run() {
        //synchronizes a variable that is used by multiple threads
        synchronized (this.names) {
            for (int i = 0; i < message.length(); i++) {
                names.add(message.charAt(i));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("charlist = " + this.names);
        }
    }

}
