package semaphore;

import java.util.concurrent.*;

/**
 * @author Lauy
 * @date 2021/3/25
 */
public class SemaphoreTest1 {
    // 创建一个semaphore 实例
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

        final Integer corePoolSize = 2;
        final Integer maximumPoolSize = 5;
        final Long keepAliveTime = 1L;

        // 创建一个线程个数固定为2的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                semaphore.release();
                System.err.println(Thread.currentThread() + " task1 - 1" + "\t");
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                semaphore.release();
                System.err.println(Thread.currentThread() + " task1 - 2" + "\t" );
            }
        });

        // 等待子线程执行完毕，返回
        semaphore.acquire(2);
        System.out.println("All child Thread over" + "\t");

        executorService.shutdown();
    }
}
