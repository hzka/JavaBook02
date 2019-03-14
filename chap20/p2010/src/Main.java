import com.sun.corba.se.spi.ior.ObjectKey;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(new Integer[]{8, 9, 2, 3, 4, 1, 5, 6, 7});
        while (heap.getSize() > 0) {
            System.out.println(heap.remove() + " ");
        }
        Patient patient01 = new Patient("John", 2);
        Patient patient02 = new Patient("Jim", 1);
        Patient patient03 = new Patient("Tim", 5);
        Patient patient04 = new Patient("Cindy", 7);

        MyPriorityQueue priorityQueue = new MyPriorityQueue();
        priorityQueue.enqueue(patient01);
        priorityQueue.enqueue(patient02);
        priorityQueue.enqueue(patient03);
        priorityQueue.enqueue(patient04);

        while (priorityQueue.getSize()>0){
            System.out.print(priorityQueue.dequeue()+" ");
        }
    }

    static class Patient implements Comparable {
        private String name;
        private int priority;
        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
        @Override
        public String toString() {
            return name + "(Priority" + priority + ")";
        }
        @Override
        public int compareTo(Object o) {
            return this.priority - ((Patient) o).priority;
        }
    }
}
