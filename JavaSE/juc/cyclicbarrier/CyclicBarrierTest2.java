package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lauy
 * @date 2021/3/25
 */
public class CyclicBarrierTest2 {

    // 创建一个CyclicBarrier 实例,添加一个所有子线程全部到达屏障后执行的任务
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {

        // 创建一个线程个数固定为2的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " step1");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " step2");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " step3");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " step1");
                cyclicBarrier.await();

                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " step2");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " step3");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
