import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        Comparable<Date> c = (Comparable<Date>) new Date();
//        System.out.println(c.compareTo("Red"));
//        ArrayList<String> list = new ArrayList<>();
//        list.add("Red");
//        list.add("White");
//        String s = list.get(0);
//        System.out.println(s);
//        ArrayList<Double> list = new ArrayList<>();
//        list.add(5.0);
//        list.add(3.3);
//        Double doubleObject = list.get(0);
//        double d = list.get(1);
//        System.out.println(doubleObject+"    "+d);

//        GenriStack<String> stack_01 = new GenriStack<>();
//        stack_01.push("London");
//        stack_01.push("Paris");
//        stack_01.push("Berlin");
//        stack_01.pop();
//        stack_01.peek();
//        stack_01.isEmpty();
//        GenriStack<Integer> stack_02 = new GenriStack<>();
//        stack_02.push(1);
//        stack_02.push(2);
//        stack_02.push(3);
//        stack_02.pop();
//        stack_02.peek();
//        stack_02.isEmpty();
        Integer[] integers = {1,2,3,4,5};
        String[] strings = {"London","Paris","Berlin"};
        Main.print(integers);
        Main.print(strings);

    }

    public static <E> void print(E[] lists){
        for(int i = 0;i<lists.length;i++){
            System.out.print(lists[i]+" ");
        }
        System.out.println();
    }
}
