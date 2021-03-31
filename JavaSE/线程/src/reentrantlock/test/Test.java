package reentrantlock.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lauy
 * @date 2021/3/22
 */
public class Test {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        ThreadA threadA = new ThreadA(lock);
        threadA.start();

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        ThreadB threadB= new ThreadB(lock);
        threadB.start();
    }
}
