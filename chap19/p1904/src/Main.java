public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Integer[] integers = {2,4,3,9,7};
        Double[] doubles = {3.4,1.3,-22.1};
        Character[] characters = {'a','J','r'};
        String [] strings = {"Tom","Susan","Kim"};

        sort(integers);
        sort(doubles);
        sort(characters);
        sort(strings);

        printList(integers);
        printList(doubles);
        printList(characters);
        printList(strings);
    }

    public static <E extends Comparable<E>> void sort(E[] list){
        E currentMin;
        int currentminIndex;

        for(int i = 0;i<list.length-1;i++){
            currentMin = list[i];
            currentminIndex = i;

            for(int j=i+1;j<list.length;j++){
                //双重循环，假若前者大于后者，则记录当前的位置和数字。
                if(currentMin.compareTo(list[j])>0){
                    currentMin = list[j];
                    currentminIndex = j;
                }
            }
            //如果不等于，则交换。
            if(currentminIndex !=i){
                list[currentminIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void printList(Object[] lists){
        for(int i = 0;i<lists.length;i++){
            System.out.print(lists[i]+"  ");
        }
        System.out.println();
    }
}
