//描述父子关系的强关系，譬如使用GeometricObject类实现了几何对象的共有特征。
public abstract class MyAbstractList implements Mylist {
    protected int size = 0;

    protected MyAbstractList() {
    }

    protected MyAbstractList(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            this.add(objects[i]);
        }
    }

    @Override
    public void add(Object o) {
        add(size, o);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object o) {
        if(indexOf(o)>=0){
            remove(indexOf(o));
            return true;
        }else{
            return false;
        }
    }
}
