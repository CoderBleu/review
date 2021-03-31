package threadlocal;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class ThreadLocalSon extends ThreadLocal {
    /*默认初始值为null*/
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }

}
