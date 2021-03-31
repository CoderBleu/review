package 单例;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class ThreadA extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            // System.out.println(Thread.currentThread().getName() + "\t：" + MyObject.getInstance().hashCode());
            System.out.println(Thread.currentThread().getName() + "\t：" + Singleton.getInstance().hashCode());
        }
    }
}
