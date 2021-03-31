package 线程组.批量停止;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class MyThread extends Thread{

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("线程组" + Thread.currentThread().getThreadGroup() + "内，线程" + Thread.currentThread().getName() + "开始死循环");

        while (!this.isInterrupted()) {

        }
        System.out.println("ThreadName" + Thread.currentThread().getName() + "结束了");
    }
}
