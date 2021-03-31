package 线程组.捕获异常;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class Main {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("我的线程组");

        for (int i = 0; i < 5; i++) {
            Thread thread = new MyThread(i+1, "第" + (i+1) + "个", threadGroup);
            thread.start();
        }

        MyThread error = new MyThread(0, "报错线程", threadGroup);
        error.start();
    }
}
