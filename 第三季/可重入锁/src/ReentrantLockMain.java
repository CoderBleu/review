import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lauy
 * @date 2021/1/29
 */
public class ReentrantLockMain {
    public static void main(String[] args) {
        new Thread(new SynchronizedTest2()).start();
    }
}

class SynchronizedTest2 implements Runnable {

    private final Lock lock = new ReentrantLock();

    public void helloA() { //方法1，调用方法2
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " helloA()");
            helloB();
        } finally {
            lock.unlock();
        }
    }

    public void helloB() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " helloB()");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        helloA();
    }
}
