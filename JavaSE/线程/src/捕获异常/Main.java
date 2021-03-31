package 捕获异常;

/**
 * @author Lauy
 * @date 2021/3/19
 */
public class Main {
    public static void main(String[] args) {
        MyThread a = new MyThread(0, "A");
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("默认的线程异常捕捉，线程名：" + t.getName());
                e.printStackTrace();
            }
        });

        // a.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
        //     @Override
        //     public void uncaughtException(Thread t, Throwable e) {
        //         System.err.println("线程名：" + t.getName());
        //         e.printStackTrace();
        //     }
        // });
        a.start();

        MyThread b = new MyThread(null, "B");
        b.start();
    }
}
