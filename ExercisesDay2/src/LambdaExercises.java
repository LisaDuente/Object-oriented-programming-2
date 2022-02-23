import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExercises {

    private static void print(List<Animal> animals, CheckTrait checker){
        for(Animal a : animals){
            if(checker.test(a)){
                System.out.print(a + " ");
            }
        }
        System.out.println();
    }

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

    }

}

