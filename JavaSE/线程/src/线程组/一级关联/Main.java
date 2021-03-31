package 线程组.一级关联;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Main {
    public static void main(String[] args) {
        // 系统环境的一个快照
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        // 在main组中添加一个线程组 A
        ThreadGroup group = new ThreadGroup(mainGroup, "A");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("runMethod!");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // 然后在 A组中添加 线程组，这个就是main组的子孙线程对象
        Thread newThread = new Thread(group, runnable);
        newThread.setName("子孙线程");
        newThread.start(); //线程必须启动然后才归到组A中

        // 子对象组
        ThreadGroup[] threadGroups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        // 将原始的Thread.currentThread().getThreadGroup()复制到该线程组及其子组中每个活动子组的指定数组引用。
        Thread.currentThread().getThreadGroup().enumerate(threadGroups);
        System.out.println("main线程中有多少个子线程组：" + threadGroups.length + "\t 名字为：" + threadGroups[0].getName());

        // 子孙对象组
        Thread[] listThread = new Thread[threadGroups[0].activeCount()];
        threadGroups[0].enumerate(listThread);
        System.out.println(listThread[0].getName());
    }
}
