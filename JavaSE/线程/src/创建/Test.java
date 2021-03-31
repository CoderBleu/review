package 创建;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        // volatileDemo.start();
        // volatileDemo.printMethod(); // 一直打印
        // new Thread(volatileDemo, "name").start(); // 线程的可见性
        // Thread.sleep(100);
        // volatileDemo.setBool(false);

        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            System.out.println(atomicInteger.incrementAndGet());
        }
    }
}
