import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*JavaCollection collection = new JavaCollection();

        collection.doTheLinkedList();
        collection.doTheHashSetThing();
        collection.doTheLinkedHashSet();
        collection.doTheTreeSet();
        collection.doTheHashMap();
        collection.doTheHashMapInception();


        HashSetExercises ex = new HashSetExercises();
        ex.appendToEnd();
        ex.iterateHashSet();
        ex.getSize();
        ex.emptySet();
        System.out.println(ex.checkHashSet());
        ex.cloneHashSet();
        ex.translateToArray();
        ex.convertToTreeSet();
        ex.convertToLists();

        HashSet<String> thisHash = new HashSet<>();
        thisHash.add("Yellow");
        thisHash.add("Green");
        thisHash.add("Red");
        thisHash.add("Blue");

        ex.compareSets(thisHash);
        ex.showAllDistinctElements(thisHash);
        ex.retainElements(thisHash);*/

        TreeSetExercises exT = new TreeSetExercises();

        exT.addColor("red");
        exT.addColor("blue");
        exT.addColor("green");

       exT.print();
       exT.iterate();

        TreeSet<String> exT2 = new TreeSet<>();

        exT2.add("pink");
        exT2.add("blue");
        exT2.add("violet");

        exT.addAllElementsFromSet2(exT2);

        TreeSet<String> exT3 = new TreeSet<>();

        exT3.add("pink");
        exT3.add("blue");
        exT3.add("yellow");

        exT.addElementsFromSet(exT3);

        exT.reverse();
        exT.firstAndLast();
        exT.cloneTreeSet();
        exT.getElements();
        exT.compareTreeSets(exT3);

    }
}

