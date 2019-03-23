import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        //采用递归的方式计算最终的结果。
//        long result = Fibonaci(3);
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        System.out.println(fib(index));
    }

    private static long fib(int index) {
        long f0 = 0;
        long f1 = 1;
        if(index == 0) return 0;
        else if(index == 1) return 1;
        for(int i = 2;i<=index;i++){
            long tmp;
            tmp = f1;
            f1 +=f0;
            f0 = tmp;
        }
        return f1;
    }

    private static long Fibonaci(int number) {
        if(number == 0) return 0;
        else if(number == 1)  return 1;
        else return Fibonaci(number-1)+Fibonaci(number-2);
    }

}
