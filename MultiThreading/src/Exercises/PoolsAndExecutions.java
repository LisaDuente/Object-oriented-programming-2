package Exercises;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolsAndExecutions {

    public void startThreadPool(){

        //this defines the order of which everything is done
        ExecutorService exSer = Executors.newSingleThreadExecutor();

        PoolsAndExecutionsRunnable one = new PoolsAndExecutionsRunnable("Task 1");
        PoolsAndExecutionsRunnable two = new PoolsAndExecutionsRunnable("Task 2");
        PoolsAndExecutionsRunnable three = new PoolsAndExecutionsRunnable("Task 3");
        PoolsAndExecutionsRunnable four = new PoolsAndExecutionsRunnable("Task 4");
        PoolsAndExecutionsRunnable five = new PoolsAndExecutionsRunnable("Task 5");
        PoolsAndExecutionsRunnable six = new PoolsAndExecutionsRunnable("Task 6");

        //add every task in the ExecutorService
        exSer.submit(one);
        exSer.submit(two);
        exSer.submit(three);
        exSer.submit(four);
        exSer.submit(five);
        exSer.submit(six);

        //close the executor
        exSer.shutdown();
    }

    public void startFixedThreadpool(){
        //defines: 3 threads should run at the same time
        ExecutorService exSer = Executors.newFixedThreadPool(3);

        PoolsAndExecutionsRunnable one = new PoolsAndExecutionsRunnable("Task 1");
        PoolsAndExecutionsRunnable two = new PoolsAndExecutionsRunnable("Task 2");
        PoolsAndExecutionsRunnable three = new PoolsAndExecutionsRunnable("Task 3");
        PoolsAndExecutionsRunnable four = new PoolsAndExecutionsRunnable("Task 4");
        PoolsAndExecutionsRunnable five = new PoolsAndExecutionsRunnable("Task 5");
        PoolsAndExecutionsRunnable six = new PoolsAndExecutionsRunnable("Task 6");

        //add every task in the ExecutorService
        exSer.submit(one);
        exSer.submit(two);
        exSer.submit(three);
        exSer.submit(four);
        exSer.submit(five);
        exSer.submit(six);

        //close the executor
        exSer.shutdown();
    }

    public void startCachedThreadpool(){
        //runs as many threads as possible
        ExecutorService exSer = Executors.newCachedThreadPool();

        PoolsAndExecutionsRunnable one = new PoolsAndExecutionsRunnable("Task 1");
        PoolsAndExecutionsRunnable two = new PoolsAndExecutionsRunnable("Task 2");
        PoolsAndExecutionsRunnable three = new PoolsAndExecutionsRunnable("Task 3");
        PoolsAndExecutionsRunnable four = new PoolsAndExecutionsRunnable("Task 4");
        PoolsAndExecutionsRunnable five = new PoolsAndExecutionsRunnable("Task 5");
        PoolsAndExecutionsRunnable six = new PoolsAndExecutionsRunnable("Task 6");

        //add every task in the ExecutorService
        exSer.submit(one);
        exSer.submit(two);
        exSer.submit(three);
        exSer.submit(four);
        exSer.submit(five);
        exSer.submit(six);

        //close the executor
        exSer.shutdown();
    }

}
