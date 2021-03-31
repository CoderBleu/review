package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lauy
 * @date 2021/3/25
 */
public class CyclicBarrierTest1 {

    // 创建一个CyclicBarrier 实例,添加一个所有子线程全部到达屏障后执行的任务
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
        System.out.println(Thread.currentThread() + " task1 merge result");
    });

    public static void main(String[] args) {

        // 创建一个线程个数固定为2的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread() + " task1 - 1");

            System.out.println(Thread.currentThread() + " enter in barrier" + cyclicBarrier.getNumberWaiting() + "\t" + cyclicBarrier.getParties());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " enter out barrier" + cyclicBarrier.getNumberWaiting() + "\t" + cyclicBarrier.getParties());
        });

        executorService.submit(() -> {
            System.err.println(Thread.currentThread() + " task1 - 2");

            System.err.println(Thread.currentThread() + " enter in barrier" + cyclicBarrier.getNumberWaiting() + "\t" + cyclicBarrier.getParties());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.err.println(Thread.currentThread() + " enter out barrier" + cyclicBarrier.getNumberWaiting() + "\t" + cyclicBarrier.getParties());
        });

        executorService.shutdown();
    }
}
