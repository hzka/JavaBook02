import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        System.out.println(GCD(number1, number2));
        System.out.println(GCD2(number1, number2));
    }

    private static int GCD2(int number1, int number2) {
        if(number1%number2==0) return number2;
        return GCD(number2,number1%number2);
    }

    private static int GCD(int number1, int number2) {
        //考虑到number1与number2整除或者称之为两者相等的情况。
        if (number1 % number2 == 0) return number2;
        for (int k = number1; k >= 1; k--) {
            if (number1 % k == 0 && number2 % k == 0) {
                return k;
            }
        }
        return 1;
    }
}
