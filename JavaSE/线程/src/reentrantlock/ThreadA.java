package reentrantlock;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class ThreadA extends Thread{

    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodA();
    }
}
