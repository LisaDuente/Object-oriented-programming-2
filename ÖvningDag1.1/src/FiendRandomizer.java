import java.util.Scanner;

public class FiendRandomizer {
    private Fiend[] fiendList;
    private int counter;
    private int place1;
    private int place2;

    public FiendRandomizer(int listLength){
        this.fiendList = new Fiend[listLength];
        this.counter = 0;
    }

    public void fillList(Fiend fiend){
        if(counter < this.fiendList.length) {
            fiendList[counter] = fiend;
            this.counter++;
        }
    }

    public void printAllFiends(){
        Fiend fiend;
        for(int i = 0; i< fiendList.length; i++){
            fiend = fiendList[i];
            fiend.toString();
            fiend.printOut();
        }
    }

    public void changePlaces(){
        if( this.place1 != this.place2){
            this.place1 = this.place1 - 1;
            this.place2 = this.place2 - 1;
            Fiend saveSpace = this.fiendList[this.place1];
            this.fiendList[this.place1] = this.fiendList[this.place2];
            this.fiendList[this.place2] = saveSpace;
        }
    }

    public int getInput(){
        System.out.println("Please enter a number between 1-5: ");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(choice < 1 || choice > 5){
            while(!scanner.hasNextInt()){
                scanner.next();
            }
            choice = scanner.nextInt();
        }
        return choice;
    }

    public void setPlace1(int place1) {
        this.place1 = place1;
    }

    public void setPlace2(int place2) {
        this.place2 = place2;
    }
}

