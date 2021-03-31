package concurrenthashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lauy
 * @date 2021/3/25
 * Thread-0：	{topic1=[device1, device2]}
 * Thread-1：	{topic1=[device11, device22]}
 * Thread-2：	{topic1=[device11, device22], topic2=[device111, device222]}
 */
public class ConcurrentHashMapTest {
    // (1) 创建map，key为topic，value为设备列表
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // (2) 进入直播间topic1，线程1
        Thread threadOne = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("device1");
            list1.add("device2");

            map.put("topic1", list1);
            System.out.println(Thread.currentThread().getName() + "：\t" + map.toString());
        });

        Thread threadTwo= new Thread(() -> {
            List<String> list2 = new ArrayList<>();
            list2.add("device11");
            list2.add("device22");

            map.put("topic1", list2);
            System.out.println(Thread.currentThread().getName() + "：\t" + map.toString());
        });

        // (2) 进入直播间topic2，线程3
        Thread threadThree = new Thread(() -> {
            List<String> list3 = new ArrayList<>();
            list3.add("device111");
            list3.add("device222");

            map.put("topic2", list3);
            System.out.println(Thread.currentThread().getName() + "：\t" + map.toString());
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
