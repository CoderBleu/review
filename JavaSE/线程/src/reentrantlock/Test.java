package reentrantlock;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        try {
            ThreadA[] threadA = new ThreadA[5];
            ThreadB[] threadB = new ThreadB[5];
            for (int i = 0; i < 5; i++) {
                // service对象需要一个，不然methodA通知了B干活但是依旧未响应。
                threadA[i] = new ThreadA(service);
                threadA[i].start();
                Thread.sleep(1000);
                threadB[i] = new ThreadB(service);
                threadB[i].start();

                // for (int i = 0; i < 5; i++) {
                //     ThreadA threadA = new ThreadA(service);
                //     ThreadB threadB = new ThreadB(service);
                //     threadA.start();
                //     Thread.sleep(1000);
                //     threadB.start();
                // }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
