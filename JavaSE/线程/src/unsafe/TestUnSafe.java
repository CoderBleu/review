package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Lauy
 * @date 2021/3/22
 */
public class TestUnSafe {

    // 获取Unsafe的实例 (2.2.1)
    // static final Unsafe unsafe = Unsafe.getUnsafe();
    static final Unsafe unsafe;

    // 记录变量state在类TestUnSafe中的偏移值 (2.2.2.)
    static final long stateOffset;

    // 变量(2.2.3)
    private volatile long state = 0;

    static {
        try {
            // 获取state变量在类TestUnsafe中的偏移量(2.2.4)：不是由Bootstrap类加载器加载，而是AppClassLoader
            // java.lang.ExceptionInInitializerError  Caused by: java.lang.SecurityException: Unsafe
            // stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));

            // 使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可存取
            field.setAccessible(true);
            // 获取该变量的值
            unsafe = (Unsafe) field.get(null);
            // 获取state在TestUnSafe中的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        // 创建实例，并且设置state值为1(2.2. 5)
        TestUnSafe test = new TestUnSafe();
        // (2.2.6)
        boolean b = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(b);
    }

}
