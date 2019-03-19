import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
//        TestingHashSet();
//        System.out.println();
////        TestingCollection();
//        TestingLinkedHashSet();
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        TreeSet<String> treeSet = new TreeSet<>(set);
        treeSet.add("xian");
        System.out.println("all tree set:" + treeSet);
        System.out.println("first()" + treeSet.first());
        System.out.println("first()" + treeSet.last());
        //小于toElement的那一部分
        System.out.println("headset?" + treeSet.headSet("New York"));
        //大于等于fromElement的那一部分
        System.out.println("tailset?" + treeSet.tailSet("New York"));

        System.out.println(treeSet.lower("P"));

        System.out.println(treeSet.higher("P"));

        System.out.println(treeSet.floor("P"));
        System.out.println(treeSet.ceiling("P"));
        System.out.println("Delete first"+treeSet.pollFirst());
        System.out.println("Delete first"+treeSet.pollLast());
        System.out.println("all tree set:" + treeSet);

    }

    private static void TestingLinkedHashSet() {
        Set<String> set = new LinkedHashSet<>();

        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        for (String s : set) {
            System.out.print(s.toUpperCase() + "  ");
        }
    }

    private static void TestingCollection() {
        Set<String> set_01 = new HashSet<>();

        set_01.add("London");
        set_01.add("Paris");
        set_01.add("New York");
        set_01.add("San Francisco");
        set_01.add("Beijing");

        System.out.println(set_01 + "  ");
        System.out.println(set_01.size() + "  ");

        Set<String> set_02 = new HashSet<>();

        set_02.add("London");
        set_02.add("Shanghai");
        set_02.add("Paris");

        System.out.println(set_02 + "  ");
        System.out.println(set_02.size() + "  ");
        System.out.println(set_02.contains("Taipei"));

        set_01.addAll(set_02);
        System.out.println(set_01);

        set_01.removeAll(set_02);
        System.out.println(set_01);

        set_01.retainAll(set_02);
        System.out.println(set_01);


    }

    private static void TestingHashSet() {
        Set<String> set = new HashSet<>();

        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        for (String s : set) {
            System.out.print(s.toUpperCase() + "  ");
        }
    }
}
