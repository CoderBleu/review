package 线程组.一级关联;


import 读写锁.Service;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class ThreadB extends Thread {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "ThreadB");
            Thread.sleep(1000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
