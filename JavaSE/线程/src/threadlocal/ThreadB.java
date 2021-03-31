package threadlocal;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class ThreadB extends Thread{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadB 线程中取值：" + Tool.threadLocal.get());
                Thread.sleep(1000);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
