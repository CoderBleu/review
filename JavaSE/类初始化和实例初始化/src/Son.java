/**
 * @author coderblue
 * @date 2021/1/28
 */
public class Son extends Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("子类的静态代码块");
    }

    Son() {
        super();
        System.out.println("子类的无参构造方法");
    }

    {
        System.out.println("子类的非静态代码块");
    }

    @Override
    public int test() {
        System.out.println("子类重写的test方法");
        return 1;
    }

    public static int method() {
        System.out.println("子类的静态方法");
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println();
        Son son1 = new Son();
    }
}