package 创建;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class VolatileDemo extends Thread{

    private volatile boolean bool = true;

    @Override
    public void run() {
        printMethod();
    }

    private void printMethod() {
        System.out.println("进入了printMethod方法");
        while (bool) {
            System.out.println(Thread.currentThread().getName() + "printMethod-ing");
        }
        System.out.println("将要退出printMethod方法");
    }

    public void setBool(boolean bool) {
        System.out.println("赋值前：" + this.isBool());
        this.bool = bool;
        System.out.println("赋值后：" + this.isBool());
    }

    public boolean isBool() {
        return bool;
    }

}
