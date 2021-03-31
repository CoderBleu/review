package 创建;

/**
 * @author Lauy
 * @date 2021/3/16
 */
public class DaemonDemo extends Thread{

    public  static int i = 0;

    @Override
    public void run() {
        try {
            for (int j = 0; j < 5; j++) {
                i++;
                System.out.println("i= " + i);
                Thread.sleep(500);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void showI(int i) {
        i = 10;
        System.out.println("final:" + DaemonDemo.i + "\t" + i);
    }

    public static void main(String[] args) {
        DaemonDemo daemonDemo = new DaemonDemo();
        daemonDemo.setDaemon(true);
        System.out.println("线程开始");
        daemonDemo.start();
        try {
            Thread.sleep(5000);
            showI(i); // 测试值传递对 i值的影响
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("离开thread线程就不再打印了");
    }
}
