package reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Service {

    private Boolean flag = true;
    private ReentrantLock lock = new ReentrantLock();
    // private Condition conditionA = lock.newCondition();
    // private Condition conditionB = lock.newCondition();

    private Condition condition = lock.newCondition();

    public void methodA() {
        lock.lock();
        try {
            while (!flag) {
                condition.await();
            }
            System.out.println("methodA在努力做个打工人..." + "\t getHoldCount： " + lock.getHoldCount()
                    + "\t getWaitQueueLength：" + lock.getWaitQueueLength(condition)
                    + "\t getQueueLength： " + lock.getQueueLength());
            flag = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            while (flag) {
                condition.await();
            }
            System.out.println("methodB在努力做个打工人..." + "\t getHoldCount： " + lock.getHoldCount()
                    + "\t getWaitQueueLength：" + lock.getWaitQueueLength(condition)
                    + "\t getQueueLength： " + lock.getQueueLength());
            flag = true;
            // 通知全部的 A 干活也行
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
