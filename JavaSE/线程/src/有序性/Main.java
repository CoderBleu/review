package 有序性;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class Main {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread a = new MyThread(obj,"a", 1, "A");
        Thread b = new MyThread(obj,"b", 2, "B");
        Thread c = new MyThread(obj,"c", 0, "C");
        a.start();
        b.start();
        c.start();
    }
}
