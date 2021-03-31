package reentrantlock.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lauy
 * @date 2021/3/22
 */
public class ThreadB extends Thread{

    private ReentrantLock lock;

    public ThreadB(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set lock! \t 持有锁的数量：" + lock.getHoldCount());
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "\t 持有锁的数量：\t" + lock.getHoldCount());
        }
    }
}
