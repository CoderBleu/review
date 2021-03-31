package threadlocal;

import java.util.Date;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class Tool {

    /**
     * 子线程和父线程保留不同的变量副本
     */
    public static ThreadLocal threadLocal = new ThreadLocalSon();

    /**
     * 子线程可以拿到父线程的值
     */
    // public static ThreadLocal threadLocal = new InheritableThreadLocalSon();

    {
        System.out.println("代码块：new 实例后，在构造方法前加载");
    }

    public Tool() {
        System.out.println("Tool对象创建了");
    }

    static {
        System.out.println("静态代码块");
    }
}
