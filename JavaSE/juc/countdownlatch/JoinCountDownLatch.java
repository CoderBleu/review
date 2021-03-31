package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Lauy
 * @date 2021/3/25
 */
public class JoinCountDownLatch {

    // 创建一个CountDownLatch实例
    private static volatile CountDownLatch countDownLatch = new CountDownLatch((2));

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("Thread One over");
        });

        threadOne.start();

        Thread threadTwo = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("Thread tow over");
        });

        threadTwo.start();

        System.out.println("wait all child thread over");
        countDownLatch.await();
        System.out.println("all child thread over：" + countDownLatch.getCount());
    }
}
