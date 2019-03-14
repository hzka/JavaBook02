public class MyQueue {
    private MyLinkedList list = new MyLinkedList();

    //队尾插入
    public void enqueque(Object o) {
        list.addLast(o);
    }

    //队头删除
    public Object dequeue() {
        return list.removeFDirst();
    }

    public int getSize() {
        return list.size;
    }

    @Override
    public String toString() {
        return "Queue" + list.toString();
    }
}
