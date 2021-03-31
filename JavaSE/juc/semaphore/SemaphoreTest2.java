package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Lauy
 * @date 2021/3/25
 */
public class SemaphoreTest2 {
    // 创建一个semaphore 实例
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

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

        // 等待子线程执行完毕，返回。会在获取到2个信号量后返回（返回后当前信号量值为0）
        semaphore.acquire(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                semaphore.release();
                System.err.println(Thread.currentThread() + " task2 - 1" + "\t");
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                semaphore.release();
                System.err.println(Thread.currentThread() + " task2 - 2" + "\t" );
            }
        });

        semaphore.acquire(2);
        System.out.println("All child Thread over" + "\t");

        executorService.shutdown();
    }
}
