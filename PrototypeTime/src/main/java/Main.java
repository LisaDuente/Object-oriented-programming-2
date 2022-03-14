public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        long last = System.nanoTime();
        long accumulator = 0L;
        //time when update() should be called (interval)
        long updateTime = 1000000000L;



        while(true){
            //save the current time
            long now = System.nanoTime();
            //compute the difference to see how much time has gone by
            long elapsed = now-last;
            //update last
            last = now;
            //increase accumulator
            accumulator += elapsed;

            //while the accumulator is bigger/equal to updateTime(Cap) call update
            while(accumulator >= updateTime){
                //decrease the accumulator with updateTime (rest remains in accumulator)
                accumulator -= updateTime;
                //from nano to milli
                model.update(updateTime/1000000);
            }
        }
    }
}
