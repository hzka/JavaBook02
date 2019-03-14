public class Main {

    public static void main(String[] args) {
        Mylist mylist = new MyArrayList();

        mylist.add("America");
        System.out.println("(1)" + mylist);

        mylist.add(0, "Canada");
        System.out.println("(2)" + mylist);


        mylist.add("Russia");
        System.out.println("(3)" + mylist);

        mylist.add("France");
        System.out.println("(4)" + mylist);


        mylist.add(3, "China");
        System.out.println("(5)" + mylist);

        mylist.remove(2);
        System.out.println("(6)" + mylist);

        mylist.remove("Canada");
        System.out.println("(7)" + mylist);

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst("America");
        System.out.println("(1)" + myLinkedList);

        myLinkedList.addLast("Canada");
        System.out.println("(2)" + myLinkedList);

        myLinkedList.add("Russia");
        System.out.println("(3)" + myLinkedList);

        myLinkedList.add("France");
        System.out.println("(4)" + myLinkedList);


        myLinkedList.add(3, "China");
        System.out.println("(5)" + myLinkedList);

        myLinkedList.remove(2);
        System.out.println("(6)" + myLinkedList);

        myLinkedList.remove("Canada");
        System.out.println("(7)" + myLinkedList);

    }
}
