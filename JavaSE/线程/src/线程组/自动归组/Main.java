package 线程组.自动归组;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class Main {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        System.out.println("A处线程：" + mainThread.getName() + "\t 所属的线程组名为：" + mainThread.getThreadGroup().getName() +
                "\t 中有线程组数量：" + mainThread.getThreadGroup().activeGroupCount());

        new ThreadGroup("新的组，自动加入main组中");

        System.out.println("B处线程：" + mainThread.getName() + "\t 所属的线程组名为：" + mainThread.getThreadGroup().getName() +
                "\t 中有线程组数量：" + mainThread.getThreadGroup().activeGroupCount());

        ThreadGroup[] threadGroups = new ThreadGroup[(mainThread.getThreadGroup().activeGroupCount())];
        mainThread.getThreadGroup().enumerate(threadGroups);
        for (int i = 0; i < threadGroups.length; i++) {
            System.out.println(threadGroups[i].getName());
        }
    }
}
