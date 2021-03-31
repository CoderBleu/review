/**
 * @author Lauy
 * @date 2021/1/29
 */
public class SynchronizedMain {
    public static void main(String[] args) {
        new Thread(new SynchronizedTest()).start();
    }
}

class SynchronizedTest implements Runnable {
    private final Object obj = new Object();

    public void helloA() { //方法1，调用方法2
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " helloA()");
            helloB();
        }
    }

    public void helloB() {
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " helloB()");
        }
    }

    @Override
    public void run() {
        helloA(); //调用helloA方法
    }
}
