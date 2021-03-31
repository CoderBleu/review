package 线程组.一级关联;


/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Test {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadGroup group = new ThreadGroup("Lauy的线程组");

        Thread threadA = new Thread(group, a, "A线程");
        Thread threadB = new Thread(group, b, "B线程");
        threadA.start();
        threadB.start();
        System.out.println("活动名称的线程数：" + group.activeCount());
        System.out.println("线程组的名称：" + group.getName());
    }
}
