package 线程组.根线程组;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class Main {
    public static void main(String[] args) {
        // 线程名：Main	 所在线程组名：java.lang.ThreadGroup[name=Main,maxpri=10]
        System.out.println("线程名：" + Thread.currentThread().getName() +
                "\t 所在线程组名：" + Thread.currentThread().getThreadGroup());
        // main线程所在的线程组的父线程组的名称是：java.lang.ThreadGroup[name=system,maxpri=10]
        System.out.println("main线程所在的线程组的父线程组的名称是：" + Thread.currentThread().getThreadGroup().getParent());
        // main线程所在的线程组的父线程组的父线程组的名称是：java.lang.ThreadGroup[name=system,maxpri=10]
        System.out.println("main线程所在的线程组的父线程组的父线程组的名称是：" + Thread.currentThread().getThreadGroup().getParent());
        // null
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent());
    }
}
