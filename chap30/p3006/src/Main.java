import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {
    private static Account account = new Account();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DepositTask());//存款进程
        executorService.execute(new WithdrawTask());//取款进程
        executorService.shutdown();
//        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    private static class DepositTask implements Runnable {//存款任务

        @Override
        public void run() {
            try {
                while (true) {
                    //sleep就是正在执行的线程主动让出CPU，CPU去执行其他线程，sleep是让出当前线程CPU
                    // 在sleep指定的时间过后，CPU才会回到这个线程上继续往下执行，
                    // 如果当前线程进入了同步锁，sleep方法并不会释放锁，即使当前线程使用sleep方法让出了CPU，
                    // 但其他被同步锁挡住了的线程也无法得到执行
                    account.deposit((int) (Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class WithdrawTask implements Runnable {//取款任务

        @Override
        public void run() {
            while (true) {
                //每次存储存1块-10块之间的随机数。
                account.withDraw((int) (Math.random() * 10) + 1);
            }
        }
    }

    private static class Account {
        //创建一个新锁
        private static Lock lock = new ReentrantLock();
        //创建一个Condition环境
        private static Condition newDeposit = lock.newCondition();

        //余额
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void withDraw(int amount) {//取款进程,参数取款数目
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("Wait for a deposit");
                    newDeposit.await();//引起线程等待，直到发出条件信号
                }
                //减去取款数目，获得余额
                balance -= amount;
                System.out.println("取款:" + amount + "\t\t余额:" + getBalance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();//释放锁
            }
        }

        public void deposit(int amount) {//存款方法，参数为存款数目
            lock.lock();//获取锁
            try {
                balance += amount;
                System.out.println("存款:" + amount + "\t\t余额:" + getBalance());
                //唤醒所有等待线程
                newDeposit.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}