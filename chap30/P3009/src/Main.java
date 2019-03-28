import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    private static Account account = new Account();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建并加载100个线程
        for (int i = 0; i < 100; i++) {
            executorService.execute(new AddAPennyTask());
        }
        //直到所有的任务执行结束。
        executorService.shutdown();
        //重复检验所有任务是否完成。
        while (!executorService.isTerminated()) {
        }
        //显示余额
        System.out.println("the balance is:" + account.getBalance());
    }

    private static class Account {
        private int balance = 0;
        private Semaphore semaphore = new Semaphore(1);

        public int getBalance() {
            return balance;
        }

        //public synchronized void deposit(int i) {
        public void deposit(int i) {
            try {
                semaphore.acquire();//获得信号量许可
                int newBalance = balance + i;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance = newBalance;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();//释放信号量许可
            }
        }
    }

    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            //执行加一操作。
//            synchronized (account) {
            account.deposit(1);
//            }
//            Set hasSet = Collections.synchronizedSet(new HashSet<>());
//            synchronized (hasSet){
//                Iterator iterator = hasSet.iterator();
//                while (iterator.hasNext()){
//                    System.out.println(iterator.next());
//                }
//            }
        }

    }
}
