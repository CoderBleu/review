import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Lauy
 * @date 2021/1/29
 *
 * 为什么唤醒两次后阻塞两次，但最终结果还会阻塞线程？
 *
 * 因为凭证的数量最多为1，连续调用两次 unpark 和 调用一次 unpark 效果一样， 只会增加一个凭证；
 * 而调用两次 park 却需要消费两个凭证，证不够，不能放行。
 */
public class Main {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in" + System.currentTimeMillis());
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "---unpark" + System.currentTimeMillis());
            System.out.println("被唤醒啦");
        }, "a");
        a.start();

        new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" +"--- 通知了");
        }, "b").start();
    }
}
