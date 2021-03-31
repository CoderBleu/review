package 创建;

import java.time.LocalDateTime;

/**
 * @author Lauy
 * @date 2021/3/16
 */
public class LockDemo {

    private Object key = new Object();
    private Object key1 = new Object();
    private Object key2 = new Object();

    static synchronized void service1() throws InterruptedException {
        System.out.println("service1：" + LocalDateTime.now());
        Thread.sleep(2000);
        // service2();
    }

    static synchronized void service2() throws InterruptedException {
        System.out.println("service2：" + LocalDateTime.now());
        Thread.sleep(2000);
        // int i = 1 / 0;
        // service3();
    }

    static synchronized void service3() {
        System.out.println("service3");
    }

    public void testLockClass() throws InterruptedException {
        synchronized (this.getClass()) {
            System.out.println("testLockClass：" + LocalDateTime.now());
            Thread.sleep(2000);
        }
    }

    public void testNoLock() throws InterruptedException {
        System.out.println("testNoLock：" + System.currentTimeMillis());
    }

    public void test2LockKey() throws InterruptedException {
        synchronized (key) {
            System.out.println("test2LockKey：" + LocalDateTime.now());
        }
        Thread.sleep(2000);
    }

    synchronized public void methodA() {
        while (true) {
            System.out.println("methodA");
        }
    }

    synchronized public void methodB() {
        System.out.println("methodB");
    }

    public void methodC() throws InterruptedException {
        synchronized (this.key1) {
            this.key1 = null;
            System.out.println("methodC" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("methodC" + System.currentTimeMillis());
        }
    }

    public void methodD() throws InterruptedException {
        synchronized (this.key2) {
            System.out.println("methodD" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("methodD" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo12 = new LockDemo();
        // lockDemo12.testLockClass();

        // new Thread(() -> {
        //     System.out.print(Thread.currentThread().getName() + "\t");
        //     // 创建.LockDemo.service1();
        //     LockDemo lockDemo = new LockDemo();
        //     try {
        //         lockDemo.testLockClass();
        //         // lockDemo.methodC();
        //         lockDemo.methodD();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     // lockDemo.testLockClass(); // synchronized (this.getClass())
        //     // lockDemo.test2LockKey();
        //     // lockDemo.testNoLock(); // test1 和 test2几乎同时进入
        //
        //     // lockDemo.methodA();
        //     // lockDemo.methodB();
        // }, "test").start();

        new Thread(() -> {
            try {
                System.out.print(Thread.currentThread().getName() + "\t");

                LockDemo lockDemo1 = new LockDemo();
                // lockDemo1.testLockClass(); // synchronized (this.getClass())
                lockDemo1.methodC();
                LockDemo.service1();
                lockDemo1.testNoLock();
                // lockDemo1.testNoLock(); // test1 和 test2几乎同时进入
            } catch(Exception e) {
                e.printStackTrace();
            }
        }, "exception").start();

    }
}
