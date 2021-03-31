package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lauy
 * @date 2021/3/25
 */
public class JoinCountDownLatchUserPool {

    // 创建一个CountDownLatch实例
    private static volatile CountDownLatch countDownLatch = new CountDownLatch((3));

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 将线程A添加到线程池
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("Thread One over");
        });

        // 将线程B添加到线程池
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("Thread tow over");
        });

        System.out.println("wait all child thread over");
        countDownLatch.await();
        System.out.println("all child thread over：" + countDownLatch.getCount());
    }
}
