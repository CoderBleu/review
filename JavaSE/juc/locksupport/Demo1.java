package locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Lauy
 * @date 2021/3/23
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("child begin park");
            LockSupport.park();
            LockSupport.park();
            System.out.println("child end park");
        });
        thread.start();

        Thread.sleep(1000);

        // 调用 unpark 方法让thread线程持有许可证，然后park方法返回
        // LockSupport.unpark(thread);

        thread.interrupt();
        System.out.printf("end park");
    }
}
