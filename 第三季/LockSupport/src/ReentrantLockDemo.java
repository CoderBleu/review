import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lauy
 * @date 2021/1/29
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in" + System.currentTimeMillis());
                try {
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒啦");
            } finally {
                reentrantLock.unlock();
            }
        }, "a").start();


        new Thread(() -> {
            reentrantLock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "--- 通知了");
            } finally {
                reentrantLock.unlock();
            }
        }, "b").start();
    }
}
