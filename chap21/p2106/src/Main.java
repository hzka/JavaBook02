import java.util.*;

public class Main {
    static final int N = 5000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
//        洗牌一样，随机打乱原来的顺序。
        //HashSet
        Collections.shuffle(list);
        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("HashSet查找时间"+getTestTime(set1)+" s");
        System.out.println("HashSet删除时间"+getRemoveTime(set1)+" s");
        //LinkedHashSet
        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println("LinkedHashSet查找时间"+getTestTime(set2)+" s");
        System.out.println("LinkedHashSet删除时间"+getRemoveTime(set2)+" s");
        //TreeSet
        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println("TreeSet查找时间"+getTestTime(set3)+" s");
        System.out.println("TreeSet删除时间"+getRemoveTime(set3)+" s");
        //ArrayList
        Collection<Integer> list1 = new ArrayList<>(list);
        System.out.println("ArrayList查找时间"+getTestTime(list1)+" s");
        System.out.println("ArrayList删除时间"+getRemoveTime(list1)+" s");
        //LinkedList
        Collection<Integer> list2 = new LinkedList<>(list);
        System.out.println("LinkedList查找时间"+getTestTime(list2)+" s");
        System.out.println("LinkedList删除时间"+getRemoveTime(list2)+" s");
    }

    private static long getTestTime(Collection<Integer> set) {
        long starttime = System.currentTimeMillis();
        for(int i = 0;i<N;i++){
            set.contains((int)(Math.random()*2*N));//一半在里面，一半在外面
        }
        return System.currentTimeMillis() - starttime;
    }
    private static long getRemoveTime(Collection<Integer> set) {
        long starttime = System.currentTimeMillis();
        for(int i = 0;i<N;i++){
            set.remove(i);
        }
        return System.currentTimeMillis() - starttime;
    }
}
