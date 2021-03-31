package reentrantlock;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}
