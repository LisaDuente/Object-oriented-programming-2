import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        JavaCollection collection = new JavaCollection();

        /*collection.doTheLinkedList();
        collection.doTheHashSetThing();
        collection.doTheLinkedHashSet();
        collection.doTheTreeSet();
        collection.doTheHashMap();
        collection.doTheHashMapInception();
         */

        HashSetExercises ex = new HashSetExercises();
        ex.appendToEnd();
        /*ex.iterateHashSet();
        ex.getSize();
        ex.emptySet();
        System.out.println(ex.checkHashSet());
        ex.cloneHashSet();
        ex.translateToArray();
        ex.convertToTreeSet();
        ex.convertToLists();
         */

        HashSet<String> thisHash = new HashSet<>();
        thisHash.add("Yellow");
        thisHash.add("Green");
        thisHash.add("Red");
        thisHash.add("Blue");

        ex.compareSets(thisHash);
        ex.showAllDistinctElements(thisHash);
        ex.retainElements(thisHash);

    }
}
