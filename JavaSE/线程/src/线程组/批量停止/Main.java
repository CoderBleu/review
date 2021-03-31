package 线程组.批量停止;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class Main {
    public static void main(String[] args) {
        try {
            ThreadGroup threadGroup = new ThreadGroup("我的线程组");
            for (int i = 0; i < 5; i++) {
                MyThread myThread = new MyThread(threadGroup, "第" + (i + 1) + "个");
                myThread.start();
            }
            Thread.sleep(5000);
            threadGroup.interrupt();
            System.out.println("调用了 interrupt 方法");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
