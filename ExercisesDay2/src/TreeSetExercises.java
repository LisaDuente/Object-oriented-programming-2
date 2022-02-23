import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExercises {
    private TreeSet<String> tree = new TreeSet<>();

    public void print(){
        System.out.println(tree);
    }

    //1. Write a Java program to create a new tree set, add some colors (string) and print out the tree set.
    public void addColor(String color){
        tree.add(color);
    }

    //2. Write a Java program to iterate through all elements in a tree set.
    public void iterate(){
        int count =1;
        Iterator<String> itr = tree.iterator();
        while(itr.hasNext()){
            String line = count +" "+ itr.next();
            System.out.println(line);
            count++;
        }
    }

    //3. Write a Java program to add all the elements of a specified tree set to another tree set.
    public void addElementsFromSet(TreeSet<String> set){
        Iterator<String> itr = set.iterator();

        while(itr.hasNext()){
            String element = itr.next();
            tree.add(element);
        }

        System.out.println(tree);
    }

    public void addAllElementsFromSet2(TreeSet<String> set){
        tree.addAll(set);
        System.out.println(tree);
    }

    //4. Write a Java program to create a reverse order view of the elements contained in a given tree set.
    public void reverse(){
        System.out.println(tree.descendingSet());
    }

    //5. Write a Java program to get the first and last elements in a tree set.
    public void firstAndLast(){
        System.out.println("first: "+tree.first());
        System.out.println("last: "+tree.last());
    }

    //6. Write a Java program to clone a tree set list to another tree set.
    public void cloneTreeSet(){
        TreeSet<String> clone = new TreeSet<>(tree);
        System.out.println(clone);
    }

    //7. Write a Java program to get the number of elements in a tree set.
    public void getElements(){
        System.out.println(tree.size());
    }

    //8. Write a Java program to compare two tree sets.
    public void compareTreeSets(TreeSet<String> set){
        System.out.println("Does Tree contains all in set? " + tree.containsAll(set));
        System.out.println("Does Set contains all in Tree? " + set.containsAll(tree));

    }

}
