package 线程组.捕获异常;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class MyThreadGroup extends ThreadGroup{

    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        System.out.println("线程组" + t.getThreadGroup() + "\t 线程名" + t.getName() + e.getMessage());
        this.interrupt();
    }
}
