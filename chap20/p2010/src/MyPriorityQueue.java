public class MyPriorityQueue {
    private Heap heap = new Heap();

    public void enqueue(Object newObject){
        heap.add(newObject);
    }

    public Object dequeue(){
       return heap.remove();
    }

    public int getSize(){
        return heap.getSize();
    }
}
