package 有序性;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class MyThread extends Thread {

    Object lock;
    private String showChar;
    private int showNumPosition;
    private int printCount = 0; //统计打印了几个字母
    volatile private static int addNumber = 1;

    /**
     *
     * @param lock 锁对象
     * @param showChar 展示的字符
     * @param showNumPosition 判断条件addNumber % 3 == this.showNumPosition
     * @param name 线程名
     */
    public MyThread(Object lock, String showChar, int showNumPosition, String name) {
        this.lock = lock;
        this.showChar = showChar;
        this.showNumPosition = showNumPosition;
        super.setName(name);
    }

    @Override
    public void run() {
        synchronized (this.lock) {
            while (true) {
                if (addNumber % 3 == this.showNumPosition) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() +
                            " runCount=" + addNumber + " showChar=" + this.showChar + " showNumPosition=" + this.showNumPosition);
                    lock.notifyAll();
                    addNumber++;
                    printCount++;
                    // 线程打印到第三次就跳出循环
                    if (this.printCount == 3) {
                        break;
                    }
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
