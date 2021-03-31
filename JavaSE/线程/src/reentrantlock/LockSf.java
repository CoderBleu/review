package reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lauy
 * @date 2021/3/22
 */
public class LockSf {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        getLock();
    }

    public static void getLock() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get Lock \t" + lock.getHoldCount());
        } finally {
            lock.unlock();
            // lock.unlock();
            System.out.println(Thread.currentThread().getName() + "\t freed Lock \t" + lock.getHoldCount());
        }
    }

    private static void setLock() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t set Lock");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
