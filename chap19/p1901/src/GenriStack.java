import java.util.ArrayList;

public class GenriStack <E>{
    private ArrayList<E> list = new ArrayList<>();

    //构造函数应当这么写。
    public GenriStack(){
    }
    public int getSize(){
        return list.size();
    }

    public E peek(){
        return list.get(getSize()-1);
    }

    public E pop(){
        E o = list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }

    public void push(E o){
        list.add(o);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
