package 读写锁;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadB.start();

        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        threadA.start();
    }
}
