//链表由结点构成，每一个节点包含一个元素，并且与下一个结点链接。
public class MyLinkedList extends MyAbstractList {
    private Node first, last;

    public MyLinkedList() {
    }

    public MyLinkedList(Object[] objects) {
        super(objects);
    }

    public Object getFirst() {
        if (size == 0) return null;
        else
            return first.element;
    }

    public Object getLast() {
        if (size == 0) return null;
        else
            return last.element;
    }

    //头插法将元素插入链表
    public void addFirst(Object o) {
        Node newNode = new Node(o);
        newNode.next = first;
        first = newNode;
        size++;

        if (last == null)
            last = first;
    }

    //尾插法将元素插入链表
    public void addLast(Object o) {
        if (last == null) {
            first = last = new Node(o);
        } else {
            last.next = new Node(o);
            last = last.next;
        }
        size++;
    }


    @Override
    public void add(int index, Object o) {
        if (index == 0) addFirst(o);
        else if (index >= size) addLast(o);
        else {
            Node current = first;
            //一直遍历到当下的节点。
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            //感觉写的很low。
//            Node temp = current.next;
//            current.next = new Node(o);
//            current.next.next = temp;
            Node temp = new Node(o);
            temp.next = current.next;
            current.next = temp;
            size++;
        }
    }

    //多考虑一些情况，长度是不是为零等等。
    public Object removeFDirst() {
        if (size == 0) return null;
        else {
            Node temp = first;
            first = first.next;
            size--;
            if (first == null) last = null;
            return temp.element;
        }
    }


    public Object removeLast() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int lastIndexof(Object o) {
        return 0;
    }

    @Override
    public Object remove(int index) {
        if ((index < 0) || (index > size)) return null;
        else if (index == 0) return removeFDirst();
        else if (index == size - 1) return removeLast();
        else {
            Node current = first;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = temp.next;
            size--;
            return temp.element;
        }
    }

    @Override
    public Object set(int index, Object o) {
        return null;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) result.append(",");
            else result.append("]");
        }
        return result.toString();
    }
}
