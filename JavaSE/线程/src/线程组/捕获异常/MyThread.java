package 线程组.捕获异常;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class MyThread extends Thread {

    private Integer count;

    public MyThread(Integer count, String name, MyThreadGroup threadGroup) {
        super(threadGroup, name);
        this.count = count;
    }

    @Override
    public void run() {
        int i = 10 / this.count;
        System.out.println("线程" + Thread.currentThread().getName() + "的计算值：" + i);
        while (this.isInterrupted() == false) {
            System.out.println("我不怕累，只想跑代码");
        }
    }
}
