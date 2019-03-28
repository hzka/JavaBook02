import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


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
        private static Lock lock = new ReentrantLock();//创建一个锁
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        //public synchronized void deposit(int i) {
        public void deposit(int i) {
            lock.lock();
            int newBalance = balance + i;

            try {
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();//释放锁
            }
        }
    }

    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            //执行加一操作。
            account.deposit(1);
        }
    }
}
