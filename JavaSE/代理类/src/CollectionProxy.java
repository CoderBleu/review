import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Lauy
 * @date 2021/3/13
 */
public class CollectionProxy {

    public static void main(String[] args) throws Exception {
        // collectionProxy(ArrayList.class);
    }

    public static void collectionProxy() throws Exception {
        //通过打印构造方法，得到的动态代理类有一个InvocationHandler参数
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        //获取Constructor类
        Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
        //传递InvocationHandler参数,手动实现InvocationHander接口
        //返回的结果是Collection接口的对象
        Collection proxy1 = (Collection) constructor.newInstance(new InvocationHandler() {
            //方法外部指定目标
            List target = new ArrayList<>();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在调用代码之后加入系统功能代码
                return method.invoke(target, args);
            }
        });
        /**
         * 通过打印生成的对象发现结果为null 有两种种可能：
         * 第一种可能是对象为null
         * 第二种可能是对象的toString()方法为null
         */
        System.out.println(proxy1);
        // 给空集合赋值
        proxy1.add("a");
        proxy1.add(12);
        proxy1.add("c");
        // 对象没有报空指针异常，所以对象的toString为null,可以得出结论，代理类对象的toString()方法被代理类重写了。
        System.out.println(proxy1.toString());
        //调用一个方法，运行成功，所以proxy1不为null
        proxy1.clear();

        proxy1.size();
    }
}
