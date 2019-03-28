import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        //创建任务
//        Runnable printA = new PrintChat('a', 10000);
//        Runnable printB = new PrintChat('b', 10000);
//        Runnable print100 = new PrintNum(100);
//        //创建线程
//        Thread thread_01 = new Thread(printA);
//        Thread thread_02 = new Thread(printB);
//        Thread thread_03 = new Thread(print100);
//        //开启线程,说白了就是不清楚输出的顺序了。
//        thread_01.start();
//        thread_02.start();
//        thread_03.start();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new PrintChat('a', 10000));
        executorService.execute(new PrintChat('b', 10000));
        executorService.execute(new PrintNum(1000));

        executorService.shutdown();
    }

    public static class PrintChat implements Runnable {
        private char charToPrint;
        private int time;

        public PrintChat(char a, int i) {
            this.charToPrint = a;
            this.time = i;
        }

        @Override
        public void run() {
            for (int i = 0; i < time; i++) {
                System.out.print(charToPrint);
//                Thread.yield();
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        }
    }

    public static class PrintNum implements Runnable {
        private int lastNum;

        public PrintNum(int i) {
            this.lastNum = i;
        }

        @Override
        public void run() {
            for (int i = 1; i <= lastNum; i++) {
                System.out.print(" " + i);
            }

        }
    }
}
