package 创建;

/**
 * @author Lauy
 * @date 2021/3/31
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(123);

        new Thread(() -> {
            System.out.println("我在异步执行");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        System.out.println(123);
    }
}
