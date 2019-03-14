import java.util.ArrayList;

public class Heap {
    private ArrayList list = new ArrayList();

    public Heap() {
    }

    public Heap(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public void add(Object newobject) {
        //1.先在队尾添加新结点。
        list.add(newobject);
        //2.确定当前的下标。更新结点的值。原理很简单，只是Arraylist的简单拓展。
        int currentIndex = list.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (((Comparable) (list.get(currentIndex))).compareTo(list.get(parentIndex)) > 0) {
                Object temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else break;
            currentIndex = parentIndex;
        }
    }

    public Object remove() {
        if (list.size() == 0) return null;
        //1.获取第零个元素，将最后一个元素放在第零个元素处。然后移除掉最后一个元素。
        Object removeObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);


        int currentIndex = 0;
        while (currentIndex < list.size() - 1) {
            int leftchildIndex = currentIndex * 2 + 1;
            int rightchildIndex = currentIndex * 2 + 2;
            //2.判断准备替换哪一个结点，替换左孩子结点还是右孩子节点。
            if (leftchildIndex >= list.size()) break;
            int maxIndex = leftchildIndex;
            if (rightchildIndex < list.size()) {
                if (((Comparable) (list.get(maxIndex))).compareTo(list.get(rightchildIndex)) < 0) {
                    maxIndex = rightchildIndex;
                }
            }
            //3.和左右节点的最大值进行交换。
            if (((Comparable) (list.get(currentIndex))).compareTo(list.get(maxIndex)) < 0) {
               Object temp = list.get(maxIndex);
               list.set(maxIndex,list.get(currentIndex));
               list.set(currentIndex,temp);
               currentIndex = maxIndex;
            }else{break;}
        }
        return removeObject;
    }

    public int getSize(){
        return list.size();
    }

}
