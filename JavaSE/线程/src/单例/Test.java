package 单例;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Test {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new ThreadA();
            threads[i].setName("线程" +( i+1));
            threads[i].start();
        }
    }
}
