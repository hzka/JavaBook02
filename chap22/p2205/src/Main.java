import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
//        TestPrimer(n);
//        EffectiveTestPrimer(n);
        SeiveOfEratosthenes(n);
    }

    private static void SeiveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n + 1];
        int count = 0;
        //初始化所有的primes。
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
//        将k*i设置成非素数
        for (int j = 2; j * j <= n; j++) {
            if (primes[j]) {
                for (int k = 2; k * j <= n; k++) {
                    primes[k * j] = false;
                }
            }
        }
        primes[0] = false;
        primes[1] = false;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                count++;
                if (count % 10 == 0) {
                    System.out.printf("%7d\n", i);
                } else {
                    System.out.printf("%7d", i);
                }
            }
        }
        System.out.println();
        System.out.print(count);
    }

    private static void EffectiveTestPrimer(int n) {
        List<Integer> list = new ArrayList<>();
        final int NUMBER_PER_LINE = 10;
        int count = 0;//计数器
        int number = 2;//当前的数字。

        while (number <= n) {
            boolean isPrime = true;
            int square = (int) (Math.sqrt(number));
            for (int k = 0; k < list.size() && list.get(k) <= square; k++) {
                //如果能整除某数，说明不是素数。
                if (number % list.get(k) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
                list.add(number);
                if (count % NUMBER_PER_LINE == 0) {
                    System.out.printf("%7d\n", number);
                } else {
                    System.out.printf("%7d", number);
                }
            }
            number++;
        }
        System.out.println();
        System.out.print(count);
    }

    private static void TestPrimer(int n) {
        final int NUMBER_PER_LINE = 10;
        int count = 0;
        int number = 2;
//        int square = 1;
        while (number <= n) {
            boolean isPrime = true;
//            if (square * square < number) square++;
            int square = (int) (Math.sqrt(number));
            for (int divisor = 2; divisor <= square; divisor++) {
                //如果能整除某数，说明不是素数。
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
                if (count % NUMBER_PER_LINE == 0) {
                    System.out.printf("%7d\n", number);
                } else {
                    System.out.printf("%7d", number);
                }
            }
            number++;
        }
        System.out.println();
        System.out.print(count);
    }
}
