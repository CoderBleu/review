package threadlocal;

/**
 * @author Lauy
 * @date 2021/3/22
 */
public class TestExtends {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Hello World!");

        new Thread(() -> {
            System.out.println(local.get());
        }).start();

        System.out.println("Main: " + local.get());
    }
}
