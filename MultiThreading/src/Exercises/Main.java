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

        Thread thread1 = new Synch(myList,message1);
        Thread thread2 = new Synch(myList,message2);

        thread1.start();
        thread2.start();
    }
}
