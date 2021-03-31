package 交替;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class ThreadB extends Thread{

    private PrintClass a;

    public ThreadB(PrintClass a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            a.printB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
