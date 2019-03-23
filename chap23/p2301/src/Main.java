public class Main {

    public static void main(String[] args) {
        int[] lists = {2, 1, 5, 4, 8, 1, -1, 10, 6};
//        Integer[] lists = {2, 1, 5, 4, 8, 1, -1, 10, 6};
        //插入排序
//        int[] resuls = InsetSort(lists);
//        for (int i = 0; i < resuls.length; i++) {
//            System.out.println(lists[i] + " ");
//        }
        //冒泡排序
//        int[] buble_results = BubbleSort(lists);
//        for (int i = 0; i < buble_results.length; i++) {
//            System.out.println(buble_results[i] + " ");
//        }
        //归并排序
//        merageSort(lists);
//        for (int i = 0; i < lists.length; i++) {
//            System.out.println(lists[i] + " ");
//        }
        //快速排序
//        QuickSort(lists);
//        for (int i = 0; i < lists.length; i++) {
//            System.out.println(lists[i] + " ");
//        }

//        Heap heap = new Heap(lists);
//        for (int i = lists.length - 1; i >= 0; i--) {
//            lists[i] = (Integer) heap.remove();
//            System.out.print(lists[i] + "  ");
//        }
        //希尔排序
//        sort(lists);
        //选择排序
        SelectSort(lists);
        for (int i = 0; i < lists.length; i++) {
            System.out.println(lists[i] + " ");
        }
    }

    /**
     * 1.插入排序。当插入第i(i>=1)个元素时，前面的V[0],…,V[i-1]等i-1个 元素已经有序。这时，
     * 将第i个元素与前i-1个元素V[i-1]，…，V[0]依次比较，找到插入位置即将V[i]插入，
     * 同时原来位置上的元素向后顺移。在这里，插入位置的查找是顺序查找。
     * 直接插入排序是一种稳定的排序算法。
     *
     * @param lists
     * @return
     */
    private static int[] InsetSort(int[] lists) {
        //1.开始遍历
        for (int i = 1; i < lists.length; i++) {
            //2.保存当前排序节点
            int currentElement = lists[i];
            int k;
            //3.从当前节点的上一节点开始检查，如果当前节点大于等于零，且上一节点的值大于当前节点的值，赋值。
            for (k = i - 1; k >= 0 && lists[k] > currentElement; k--) {
                lists[k + 1] = lists[k];
            }
            //4.否则，对于lists[k+1]进行赋值
            lists[k + 1] = currentElement;
        }
        //5.返回数组。
        return lists;
    }

    /**
     * 2.冒泡排序。双重循环遍历。
     * （1）比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * （2）对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * （3）针对所有的元素重复以上的步骤，除了最后一个。
     * （4）持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param lists
     * @return
     */
    private static int[] BubbleSort(int[] lists) {
        //1.若一次循环没有发生交换，那么后面的也就不用做了。
        boolean nedNextPass = true;
        //2.双重循环遍历，进行交换。确定从小到大的顺序。
        for (int k = 0; k < lists.length && nedNextPass; k++) {
            nedNextPass = false;
            for (int i = 0; i < lists.length - 1; i++) {
                int j = i + 1;
                if (lists[i] > lists[j]) {
                    int tmp = lists[j];
                    lists[j] = lists[i];
                    lists[i] = tmp;
                    nedNextPass = true;
                }
            }
        }
        return lists;
    }

    /**
     * 3.归并排序（1）申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     * （2）设定两个指针，最初位置分别为两个已经排序序列的起始位置
     * （3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     * （4）重复步骤3直到某一指针超出序列尾
     * （5）将另一序列剩下的所有元素直接复制到合并序列尾
     *
     * @param lists
     * @return
     */
    private static void merageSort(int[] lists) {
        if (lists.length > 1) {
            //1.拆分前面一半
            int[] firstHalf = new int[lists.length / 2];
            System.arraycopy(lists, 0, firstHalf, 0, lists.length / 2);
            merageSort(firstHalf);
            //2.拆分前面一半
            int secondHalfLength = lists.length - lists.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(lists, lists.length / 2, secondHalf, 0, secondHalfLength);
            merageSort(secondHalf);
            //3.合并
            merage(firstHalf, secondHalf, lists);
        }
    }

    private static void merage(int[] list1, int[] list2, int[] temp) {
        int current1 = 0;//list1开始位置
        int current2 = 0;//list2开始位置
        int current3 = 0;//list3开始位置

        //比较累加填充，有意思。
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    /**
     * 4.设要排序的数组是A[0]……A[N-1]，首先任意选取一个数据（通常选用数组的第一个数）
     * 作为关键数据，然后将所有比它小的数都放到它前面，所有比它大的数都放到它后面，
     * 这个过程称为一趟快速排序。值得注意的是，快速排序不是一种稳定的排序算法，也就是说
     * ，多个相同的值的相对位置也许会在算法结束时产生变动。
     */
    private static void QuickSort(int[] lists) {
        QuickSort(lists, 0, lists.length - 1);
    }

    private static void QuickSort(int[] lists, int first, int last) {
        if (first < last) {
            int pivoIndex = partition(lists, first, last);
            QuickSort(lists, first, pivoIndex - 1);
            QuickSort(lists, pivoIndex + 1, last);
        }
    }

    private static int partition(int[] lists, int first, int last) {
        int pivot = lists[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && lists[low] <= pivot) low++;
            while (low <= high && lists[high] > pivot) high--;
            if (high > low) {
                int temp = lists[high];
                lists[high] = lists[low];
                lists[low] = temp;
            }
        }
//        return high;
        while (high > first && lists[high] >= pivot) high--;
        if (pivot > lists[high]) {
            lists[first] = lists[high];
            lists[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    /**
     * 希尔排序
     * :设待排序元素序列有n个元素，首先取一个整数increment（小于n）作为间隔将全部元素
     * 分为increment个子序列，所有距离为increment的元素放在同一个子序列中，在每一个
     * 子序列中分别实行直接插入排序。然后缩小间隔increment，重复上述子序列划分和排序工作。
     * 直到最后取increment=1，将所有元素放在同一个子序列中排序为止。
     *
     * @param arrays 需要排序的序列
     */
    public static void sort(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return;
        }
        //增量
        int incrementNum = arrays.length / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < arrays.length; i++) {
                //进行插入排序
                for (int j = i; j < arrays.length - incrementNum; j = j + incrementNum) {
                    if (arrays[j] > arrays[j + incrementNum]) {
                        int temple = arrays[j];
                        arrays[j] = arrays[j + incrementNum];
                        arrays[j + incrementNum] = temple;
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum / 2;
        }
    }

    /**
     * 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到全部待排序的数据元素排完。
     * @param lists
     */
    private static void SelectSort(int[] lists) {
        for (int i = 0; i < lists.length - 1; i++) {
            for (int j = i; j < lists.length; j++) {
                if (lists[i] > lists[j]) {
                    int tmp = lists[i];
                    lists[i] = lists[j];
                    lists[j] = tmp;
                }
            }
        }
    }
//    void bucketsort(Integer[] list){
//    }
}
