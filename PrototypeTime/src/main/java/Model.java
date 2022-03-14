public class Model {
        long timeUntilHungry;

    public Model(){
        this.timeUntilHungry = 10000;
    }

    //in milliseconds
    public void update(long elapsed){
        //takes in the time passed and decreases timeUntilHungry
        this.timeUntilHungry -= elapsed;
        //if timeUntilHungry reaches 0, prints out hungry and resets timeUntilHungry
        if(this.timeUntilHungry <= 0){
            System.out.println("HUNGRY!");
            this.timeUntilHungry= 10000;
        }
        System.out.println(elapsed);
    }
}
