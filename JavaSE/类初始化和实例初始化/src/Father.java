/**
 * @author coderblue
 * @date 2021/1/28
 */
public class Father {
    static {
        System.out.println("父类静态代码块");
    }

    private int i = test();
    private static int j = method();

    Father() {
        System.out.println("父类构造方法");
    }

    {
        System.out.println("非静态代码块");
    }

    public int test() {
        System.out.println("父类test方法");
        return 1;
    }

    public static int method() {
        System.out.println("父类静态方法");
        return 1;
    }
}