import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    /*brings functional programming to java
    advantages: more efficient, parallelStreams for multi threads
    SOURCE -> INTERMEDIATE OPERATION(S) -> TERMINAL OPERATION
    Source = collection (list, array, set, map)
    intermediate operations = return a stream (filter(), skip(), map(), sort())
    Terminal operation = (forEach(), collect(), reduce(), count())
     */

    public static void main(String[] args) {
        IntStream                                       //Source
                .range(1,10)                            // fill source | intermediate operation
                .forEach(e -> System.out.print(e));   // Terminal operation
        System.out.println();

        IntStream
                .range(1,20)
                .skip(5)                                    //skips the first 5 numbers
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        System.out.println(                             //needs a print to make the number visible
                IntStream
                        .range(1,5)                     // the last number is excluded ( 5 is excluded)
                        .sum());


        Stream.of("Ava","Aneri","Alberto")              // takes in objects and primitive data types
                .sorted()                               //sorts in natural order
                .findFirst()                            // returns an optional describing the first element in stream
                .ifPresent(e -> System.out.println(e)); // performs the given method if there is a value

        String[] frukt = {"Banan", "Äpple","Körsbär","Blåbär","Druvor", "Ananas"};
        Arrays.stream(frukt)
                .filter( e -> e.startsWith("B"))               //only returns the strings with first letter B
                .sorted()                                      // sorts in natural order
                .forEach(e -> System.out.print(e + " "));      // prints out the sorted stream
        System.out.println();

        Arrays.stream(frukt)
                .filter ( e -> e.startsWith("B"))
                .sorted((s,z) -> z.compareTo(s))                // to get the reverse order use a comparator and compareTo from the comparator class
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        Arrays.stream(new int[] {1,2,3,4,5})
                .map(x -> x*x)                                  // to compute the described function on each object in the stream
                .average()                                      // this is the terminal operation
                .ifPresent(e -> System.out.print(e + " "));     // checks the result, if it exists it does something
        System.out.println();

        IntStream
                .range(1,21)
                .filter(s -> s%2 == 0)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        List<String> people = Arrays.asList("Lisa", "Georg", "Tim", "Nils", "Jan", "Maren", "Cornelia", "Svenja", "Cora", "Mila", "Leon");
        people
                .stream()                                   //creates a stream pipeline with people as source
                .map(e -> e.toLowerCase())                  // String::toLowerCase
                .filter( e -> e.contains("l") || e.contains("o"))
                .forEach(e -> System.out.print(e + " "));   //System.out::println if you just want to print put e
                System.out.println();

        try{
            Stream<String> bands = Files.lines(Paths.get("src/bands")); //make a stream with a file as a source
            bands
                    .sorted(Comparator.comparing(String::length))           //starts with the smallest
                    .filter(x -> x.length() > 9)
                    .forEach(e -> System.out.print(e + ", "));
            bands.close();                                                     //close the stream to save memory
            System.out.println();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println();

        try {
            List<String> bands2 = Files.lines(Paths.get("src/bands"))       //creates a stream that is saved in a List variable
                    .filter(x -> x.contains("an"))
                    .collect(Collectors.toList());
            bands2.forEach(x -> System.out.print(x + ", "));
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println();

        //counts the rows with three strings that are separated by a comma
        try{
            Stream<String> rows = Files.lines(Paths.get("src/bands"));
            int rowCount = (int)rows
                    .map(x -> x.split(",")) //splits all rows accordingly to each word in a String[]
                    .filter(x -> x.length == 3)   // filters all string arrays with size 3
                    .count();                       // counts everything that is still in stream
            System.out.println(rowCount + " rows");
            rows.close();                           // you need to close it if you created a stream object
        }catch(IOException e){
            e.printStackTrace();
        }

        //writes out lines with a number in the middle
        try{
            Stream<String> rows2 = Files.lines(Paths.get("src/bands"));
            rows2
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 3)
                    .filter ( x -> Integer.parseInt(x[1])>15) //no spaces in the file between comma and string
                    .forEach(x ->System.out.println(x[0] + " "+ x[1]+ " "+ x[2]));
        }catch(IOException e){
            e.printStackTrace();
        }

        try{
            Stream<String> rows3 = Files.lines(Paths.get("src/bands"));
            Map<String, Integer> map = new HashMap<>();
            map = rows3
                    .map(x -> x.split(","))
                    .filter(x -> x.length == 3)
                    .filter(x -> Integer.parseInt(x[1]) > 15)
                    .collect(Collectors.toMap(
                            x -> x[0],
                            x -> Integer.parseInt(x[1])
                    )); //return a map with this specs
            rows3.close();

            for(String key : map.keySet()){
                System.out.println(key + "_" + map.get(key));
            }
        }catch(IOException e){
            e.printStackTrace();
        }



    }
}

