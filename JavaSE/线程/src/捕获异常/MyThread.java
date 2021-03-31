package 捕获异常;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class MyThread extends Thread {

    private Integer count;

    public MyThread(Integer count, String name) {
        this.count = count;
        super.setName(name);
    }

    @Override
    public void run() {
        int i = 10 / this.count;
        System.out.println("线程" + Thread.currentThread().getName() + "的计算值：" + i);
    }
}
