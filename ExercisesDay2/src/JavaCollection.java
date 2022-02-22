import java.util.*;

public class JavaCollection {

    public void doTheLinkedList(){
    //linkedList, better to manipulate, more space in memory
    //functions like arrayList
    LinkedList<Double> linkedList = new LinkedList<>();
    linkedList.add(20.1);
    linkedList.add(20.2);
    linkedList.add(20.3);

    System.out.println(linkedList);
    }

    public void doTheHashSetThing(){

        //create a HashSet, the HashSet inherits from Set
        //a set saves just unique values
        Set<String> set = new HashSet<>();
        set.add("Lisa");
        set.add("Georg");
        set.add("Nils");
        //this wont be saved in the HashSet
        set.add("Lisa");
        //this should be saved in the HashSet because of case sensitivity
        set.add("lisa");
        //to find a value in a HashSet
        System.out.println(set.contains("Lisa"));

        //this set sorts the inputs after hashing code
        System.out.println(set);
    }

    public void doTheLinkedHashSet(){
        //uses the sequence in which you put in the information
        Set<String> linked = new LinkedHashSet<>();
        linked.add("Lisa");
        linked.add("Georg");
        linked.add("Nils");

        System.out.println(linked);
        // print is: Lisa, Georg, Nils
    }

    public void doTheTreeSet(){
        //inherits from set but you can also write TreeSet
        // good to use if you want to have sorted by alphabet
        Set<String> set = new TreeSet<>();
        set.add("Lisa");
        set.add("Georg");
        set.add("Nils");

        System.out.println(set);
        //sorts everything in alphabetical order / ASCI (first big letters, then small letters)

    }

    public void doTheHashMap(){
        //create a map with two datatypes (key and value)
        //sorts like a HashSet
        Map<Integer,String> map = new HashMap<>();
        //add a value with put
        map.put(1,"Lisa");
        map.put(2,"Georg");
        map.put(3,"Nils");
        //this will replace Georg because the key is unique
        map.put(2,"Tim");

        System.out.println(map);
    }

    public void doTheHashMapInception(){
        HashMap<String,String> map1 = new HashMap<>();
        //add a value with put
        map1.put("one","Lisa");
        map1.put("two","Georg");
        map1.put("three","Nils");

        //sorts the keys in alphabetical order
        TreeMap<Integer,HashMap<String,String>> map = new TreeMap<>();
        map.put(1,map1);

        System.out.println(map);
    }

}
