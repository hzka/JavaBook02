//使用接口来表示弱关系（类属关系），表示对象拥有某种属性，譬如：所有字符串都是可以比较的。
public interface Mylist {
    public void add(Object o);

    public void add(int index, Object o);

    public void clear();

    public Object get(int index);

    public int indexOf(Object o);

    public boolean contains(Object o);

    public boolean isEmpty();

    public int lastIndexof(Object o);

    public boolean remove(Object o);

    public int size();

    public Object remove(int index);

    public Object set(int index, Object o);
}
