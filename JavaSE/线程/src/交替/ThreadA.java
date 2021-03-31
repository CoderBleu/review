package 交替;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class ThreadA extends Thread{

    private PrintClass a;

    public ThreadA(PrintClass a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            a.printA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
