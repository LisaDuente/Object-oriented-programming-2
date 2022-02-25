import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LambdaExercises {

    private static void print(List<Animal> animals, CheckTrait checker){
        for(Animal a : animals){
            if(checker.test(a)){
                System.out.print(a + " ");
            }
        }
        System.out.println();
    }

    /*public static int returnRandom(Supplier<Integer> sup){
        int j = sup.get() + 1;
        return j;
    }

     */

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Fish", false, true));
        animals.add(new Animal("Cow", true, false));
        animals.add(new Animal("Beaver", true, true));

        //this works because we refere to a CheckTrait functional interface (just one method)
        //Java knows that it can only have one method, this method is described through the lambda expression
        //the expressions name is test and is called in print
        //because of the interface we know test returns a boolean, which can be used to operate in print
        //the function also uses only one parameter

       print(animals, a ->  a.isSwimmer());
       print(animals, b -> b.isRunner());
       print(animals, (a) -> {return a.canRun;});

       List<String> test = new ArrayList<>();
       test.add("Bill");
       test.add("Marie");
       test.add("Darth Vader");
       test.add("Leia Skywalker");

       System.out.println(test);

       //use a comparator to sort the list by your own choice
        // the compare function of a comparator returns an integer
        //compareTo() is a function from Comparator Class and takes in two parameters and returns an integer
        test.sort((p, b) -> p.compareTo(b));
        System.out.println(test);

        //in collections you can use forEach() to replace a loop
        // it takes in a Consumer and that one takes in a parameter but returns nothing
        test.forEach(p -> System.out.println(p));

        //this is going to write out a name and a random number next to it
        //use a supplier to generate a value
        Supplier<Integer> random = () -> new Random().nextInt(10);
        test.forEach(p -> System.out.println(p + " "+random));


        //takes in a predicate, the lambda expression should return a boolean
        test.removeIf(p -> p.charAt(1) == 'a');
        System.out.println(test);


    }

}

