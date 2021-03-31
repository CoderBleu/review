package threadlocal;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Test {
    public static void main(String[] args) {

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("在Main线程中取值 =" + Tool.threadLocal.get());
                Thread.sleep(1000);
            }
            ThreadA a = new ThreadA();
            a.start();
            ThreadB b = new ThreadB();
            b.start();
            // Thread.sleep(2000);
            // Tool.threadLocal.set("main线程修改值");
            System.err.println("main线程修改值后：" + Tool.threadLocal.get());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
