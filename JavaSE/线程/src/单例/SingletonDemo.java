package 单例;

/**
 * @author Lauy
 * @date 2021/3/18
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }

}

class Singleton {
    // 1.构造器私有化，不允许外部实例化
    private Singleton() {
    }

    // 2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3.提供一个公用的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}
