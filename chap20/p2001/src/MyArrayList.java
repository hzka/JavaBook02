public class MyArrayList extends MyAbstractList {
    public static final int INITAL_CAPCITY = 16;
    private Object[] data = new Object[INITAL_CAPCITY];

    public MyArrayList() {

    }

    public MyArrayList(Object[] objects) {
        data = objects;
        size = objects.length;
    }


    @Override
    public void add(int index, Object o) {
        //先判断是否有空间，若没有，创建当前里两倍大小新数组，复制过去
        ensureCapcity();
        //移动时整体后移
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        //在指定位置放置数组,顺便增加数组长度。
        data[index] = o;
        size++;
    }

    private void ensureCapcity() {
        if (size >= data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    @Override
    public void clear() {
        data = new Object[INITAL_CAPCITY];
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i]))
                return true;
        }
        return false;
    }

    //反向遍历获取最后一个该元素的位置
    @Override
    public int lastIndexof(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public Object remove(int index) {
        Object o = data[index];

        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        size--;
        return o;
    }

    @Override
    public Object set(int index, Object o) {
        Object old = data[index];
        data[index] = o;
        return old;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(",");
        }

        return result.toString() + "]";
    }
}
