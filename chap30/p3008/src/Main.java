import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {

    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new ProduceTask());
        executorService.execute(new ConsumerTask());
        executorService.shutdown();
    }

    private static class ProduceTask implements Runnable {
        @Override
        public void run() {
            int i = 1;
            try {
                while (true) {
                    System.out.println("Produce writes" + i);
                    buffer.put(i++);
//                buffer.write(i++);
                    try {
                        Thread.sleep((int) (Math.random() * 10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ConsumerTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Consumer reads:" + buffer.take());
                    try {
                        Thread.sleep((int) (Math.random() * 10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//    private static class Buffer {
//        private static final int CAPACITY = 1;
//        private LinkedList<Integer> queue = new LinkedList<>();
//
//        private static Lock lock = new ReentrantLock();
//        //创建两个新锁及相应的Condition
//        private static Condition notEmpty = lock.newCondition();
//        private static Condition notFull = lock.newCondition();
//
//        public void write(int value) {
//            lock.lock();//获取锁
//            //若满，则唤起等待进程，无法写。
//            try {
//                while (queue.size() == CAPACITY) {
//                    System.out.println("缓冲区已满,无法添加,等待notFull信号");
//                    notFull.await();
//                }
//                queue.offer(value);
//                notEmpty.signal();//增加一个元素，有得删除了。唤醒未满notEmpty。唤醒非空Condition
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();//释放锁
//            }
//        }
//
//        public int read() {
//            int value = 0;
//            lock.lock();//获取锁
//            try {
//                while (queue.isEmpty()) {
//                    System.out.println("缓冲区已空,无法删除,等待notEmpty信号");
//                    notEmpty.await();
//                }
//                value = queue.remove();
//                notFull.signal();//删除一个元素，腾出一个空间，非空，有得写入了。唤醒未满notFull。
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();//释放锁
//                return value;
//            }
//        }
//    }

