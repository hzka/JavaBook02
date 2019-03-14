public class MyStack {
    private MyArrayList list =new MyArrayList();
    public void push(Object o){
       list.add(o);
    }

    public Object pop(){
        Object o = list.remove(list.size-1);
        return o;
    }

    @Override
    public String toString() {
        return "Stack:"+list.toString();
    }
}
