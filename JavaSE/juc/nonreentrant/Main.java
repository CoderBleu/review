package nonreentrant;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;

/**
 * @author Lauy
 * @date 2021/3/23
 */
public class Main {
    final static NonReentrantLock lock = new NonReentrantLock(); // 自定义的不可重入锁
    final static Condition consumerThread = lock.newCondition(); // 消费者线程
    final static Condition producerThred = lock.newCondition(); // 生产者线程

    final static Queue<String> queue = new LinkedBlockingDeque<String>();
    final static int queueSize = 10;

    public static void main(String[] args) {

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();
                try {
                    // (1) 如果队列满了，则等待
                    while (queue.size() == queueSize) {
                        try {
                            producerThred.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // (2) 添加元素到队列
                    queue.add(UUID.randomUUID().toString().replace("-", ""));
                    // (3) 唤醒消费线程
                    consumerThread.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();
                try {
                    // 队列空，则等待
                    while (queue.size() == 0) {
                        try {
                            consumerThread.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 消费一个元素：检索并删除此队列的开头，返回此队列的头元素，如果此队列为空，则返回null
                    String element = queue.poll();
                    System.out.println(Thread.currentThread().getName() + "正在消费：" + element);
                    // 唤醒生产线程
                    producerThred.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        producer.setName("producer");

        consumer.start();
        consumer.setName("consumer");

        System.out.println(System.currentTimeMillis() + "\t" + System.nanoTime() );
        System.out.println((1 << 8 )+ "\t"  + (256 * 256));
        System.out.println(4 >> 2);
        System.out.println(4 >>> 2);
        System.out.println(8 >> 2);
        System.out.println("最后：" + (10 & 63355));
        System.out.println("最后：" + (10 & 7));

        int a = 1;
        int b = 2;
        a = b = 3;
        System.out.println();

    }
}
