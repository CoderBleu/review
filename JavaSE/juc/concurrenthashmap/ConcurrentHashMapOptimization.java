package concurrenthashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lauy
 * @date 2021/3/25
 */
public class ConcurrentHashMapOptimization {
    // (1) 创建map，key为topic，value为设备列表
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // (2) 进入直播间topic1，线程1
        Thread threadOne = new Thread(() -> {
            List<String> list1 = new ArrayList<>();
            list1.add("device1");
            list1.add("device2");

            List<String> topic1 = map.putIfAbsent("topic1", list1);
            if (topic1 != null) {
                topic1.addAll(list1);
            }
            System.out.println(Thread.currentThread().getName() + "：\t" + map.toString());
        });

        Thread threadTwo= new Thread(() -> {
            List<String> list2 = new ArrayList<>();
            list2.add("device11");
            list2.add("device22");

            List<String> topic1 = map.putIfAbsent("topic1", list2);
            if (topic1 != null) {
                topic1.addAll(list2);
            }
            System.out.println(Thread.currentThread().getName() + "：\t" + map.toString());
        });

        // (2) 进入直播间topic2，线程3
        Thread threadThree = new Thread(() -> {
            List<String> list3 = new ArrayList<>();
            list3.add("device111");
            list3.add("device222");

            List<String> topic2 = map.putIfAbsent("topic2", list3);
            if (topic2 != null) {
                topic2.addAll(list3);
            }
            System.out.println(Thread.currentThread().getName() + "：\t" + map.toString());
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
