package cas;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Lauy
 * @date 2021/3/23
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Object> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("china");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne：" + arrayList);
                // 修改list中下标为1的元素为 heihei
                arrayList.set(1, "shoppe");
                // 删除元素
                arrayList.remove(2);
                arrayList.remove(3);
                System.out.println("threadOne：" + arrayList);
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadTwo：" + arrayList);
                // 修改list中下标为1的元素为 heihei
                arrayList.set(2, "shoppers");
                // 删除元素
                System.out.println("threadTwo：" + arrayList);
            }
        });

        // 宝藏在修改线程启动前获取迭代器
        Iterator<Object> iterator = arrayList.iterator();

        threadOne.start();
        threadOne.join();
        Thread.sleep(2000);
        threadTwo.join();
        threadTwo.start();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
