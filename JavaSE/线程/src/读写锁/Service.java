package 读写锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(1000);
            } finally {
                lock.readLock().unlock();
                System.out.println("释放读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(1000);
            } finally {
                lock.writeLock().unlock();
                System.out.println("释放写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
