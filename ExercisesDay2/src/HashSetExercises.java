import java.util.*;

public class HashSetExercises {

    private HashSet<String> hash = new HashSet();

    //1. Write a Java program to append the specified element to the end of a hash set.
    public void appendToEnd(){
        hash.add("Blue");
        hash.add("Red");
        hash.add("Yellow");

        System.out.println(hash);
        //You cannot append something to the end because the set sorts by hash value
    }

    //2. Write a Java program to iterate through all elements in a hash list.
    public void iterateHashSet(){

        //create an iterator and use it on the hashSet
        Iterator<String> itr = hash.iterator();

        //run the iterator like a scanner
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    //3. Write a Java program to get the number of elements in a hash set.
    public void getSize(){
        System.out.println(hash.size());
    }

    //4. Write a Java program to empty a hash set.
    public void emptySet(){
        hash.clear();
        System.out.println(hash);
    }

    //5. Write a Java program to test a hash set is empty or not.
    public boolean checkHashSet(){
        return hash.isEmpty();
    }

    //6. Write a Java program to clone a hash set to another hash set.
    public void cloneHashSet(){
        HashSet hash2 = new HashSet();
        hash2 = (HashSet)hash.clone();
        //to clone a HashSet you need to cast it, because the clone() method does only return objects
        System.out.println("hash1: " + hash);
        System.out.println("hash2: " + hash2);
    }

    //7. Write a Java program to convert a hash set to an array.
    public void translateToArray(){
        //the .toArray() method returns an Object[]
        Object[] hashArray = hash.toArray();
        System.out.println("Array from hash: " + Arrays.toString(hashArray));
    }

    //8. Write a Java program to convert a hash set to a tree set.
    public void convertToTreeSet(){
        //just put the hashset in the new treeset
        TreeSet<String> tree = new TreeSet<>(hash);
        System.out.println("tree: "+tree);
    }

    //9. Write a Java program to convert a hash set to a List/ArrayList.
    public void convertToLists(){
        ArrayList<String> array = new ArrayList<>(hash);
        LinkedList<String> list = new LinkedList<>(hash);

        System.out.println("Array: " + array);
        System.out.println("List: " + list);
    }

    //10. Write a Java program to compare two hash set.
    public void compareSets(HashSet<String> set){
        //you can use the .equals method from Objects
        System.out.println(hash.equals(set));
    }

    //11. Write a Java program to compare two sets and retain elements which are same on both sets.
    public void showAllDistinctElements(HashSet<String> set){
        Iterator<String> itr = hash.iterator();
        String distinct = "";

        //first check if there is something that isn't contained in the first hashset
        while(itr.hasNext()){
            String element = itr.next();
            if(!set.contains(element)){
                distinct = distinct + element + ", ";
            }
        }
        //then get in the distinct values from the second hashset
        itr = set.iterator();
        while(itr.hasNext()){
            String element = itr.next();
            if(!hash.contains(element)){
                distinct = distinct  + element + ", ";
            }
        }

        System.out.println(distinct);
    }

    public void retainElements(HashSet<String> set){
        //all the values that are not contained in hash will be erased from set
        set.retainAll(hash);
        System.out.println("hash: " + hash);
        System.out.println("parameter set: " + set);
    }
}
