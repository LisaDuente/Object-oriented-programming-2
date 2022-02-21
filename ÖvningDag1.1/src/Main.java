public class Main {
    public static void main(String[] args) {
        FiendRandomizer list = new FiendRandomizer(5);

        Fiend fiend1 = new Fiend("chainsaw",20,15);
        Fiend fiend2 = new Fiend("hammer",25,25);
        Fiend fiend3 = new Fiend("shuriken",5,5);
        Fiend fiend4 = new Fiend("bow",15,10);
        Fiend fiend5 = new Fiend("shovel",20,20);

        list.fillList(fiend1);
        list.fillList(fiend2);
        list.fillList(fiend3);
        list.fillList(fiend4);
        list.fillList(fiend5);

        list.printAllFiends();

        list.setPlace1(list.getInput());
        list.setPlace2(list.getInput());

        list.changePlaces();

        list.printAllFiends();

    }
}
