package locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Lauy
 * @date 2021/3/23
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        System.out.println("begin park");
        LockSupport.unpark(Thread.currentThread());
        System.out.printf("end park, but %s isn't end!", Thread.currentThread().getName());
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%d", 1);
            LockSupport.unpark(Thread.currentThread());
        }).start();
        // LockSupport.park();


        // LockSupport.unpark(Thread.currentThread());
    }
}
