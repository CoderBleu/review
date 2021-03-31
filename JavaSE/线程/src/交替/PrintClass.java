package 交替;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class PrintClass {

    private volatile boolean bool = false;

    public synchronized void printA() throws InterruptedException {
        while (bool) {
            this.wait();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("AAAAA");
        }
        this.bool = true;
        this.notifyAll();
    }

    public synchronized void printB() throws InterruptedException {
        while (!bool) {
            this.wait();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("BBBBB");
        }
        this.bool = false;
        this.notifyAll();
    }
}
