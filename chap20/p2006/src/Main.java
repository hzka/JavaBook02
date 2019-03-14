public class Main {

    public static void main(String[] args) {
//        Mylist mylist = new MyArrayList();
//
//        mylist.add("America");
//        System.out.println("(1)" + mylist);
//
//        mylist.add(0, "Canada");
//        System.out.println("(2)" + mylist);
//
//
//        mylist.add("Russia");
//        System.out.println("(3)" + mylist);
//
//        mylist.add("France");
//        System.out.println("(4)" + mylist);
//
//
//        mylist.add(3, "China");
//        System.out.println("(5)" + mylist);
//
//        mylist.remove(2);
//        System.out.println("(6)" + mylist);
//
//        mylist.remove("Canada");
//        System.out.println("(7)" + mylist);
//
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addFirst("America");
//        System.out.println("(1)" + myLinkedList);
//
//        myLinkedList.addLast("Canada");
//        System.out.println("(2)" + myLinkedList);
//
//        myLinkedList.add("Russia");
//        System.out.println("(3)" + myLinkedList);
//
//        myLinkedList.add("France");
//        System.out.println("(4)" + myLinkedList);
//
//
//        myLinkedList.add(3, "China");
//        System.out.println("(5)" + myLinkedList);
//
//        myLinkedList.remove(2);
//        System.out.println("(6)" + myLinkedList);
//
//        myLinkedList.remove("Canada");
//        System.out.println("(7)" + myLinkedList);
        MyStack myStack = new MyStack();
        myStack.push("Tom");
        System.out.println("(1)"+myStack);

        myStack.push("John");
        System.out.println("(2)"+myStack);

        myStack.push("George");
        myStack.push("Michel");
        System.out.println("(3)"+myStack);
        System.out.println("(4)"+myStack.pop());
        System.out.println("(5)"+myStack.pop());
        System.out.println("(6)"+myStack);


        MyQueue myQueue = new MyQueue();
        myQueue.enqueque("Tom");
        System.out.println("(7)"+myQueue);

        myQueue.enqueque("John");
        System.out.println("(8)"+myQueue);

        myQueue.enqueque("George");
        myQueue.enqueque("Michel");
        System.out.println("(9)"+myQueue);
        System.out.println("(10)"+myQueue.dequeue());
        System.out.println("(11)"+myQueue.dequeue());
        System.out.println("(12)"+myQueue);

    }
}
