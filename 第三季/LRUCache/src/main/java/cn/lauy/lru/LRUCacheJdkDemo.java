package cn.lauy.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Lauy
 * @date 2021/2/1
 */
public class LRUCacheJdkDemo<K, V> extends LinkedHashMap<K,V> {
    private int capacity; //缓存坑位

    public LRUCacheJdkDemo(int capacity) {
        super(capacity, 0.75F, false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheJdkDemo lruCacheJdkDemo = new LRUCacheJdkDemo(3);
        lruCacheJdkDemo.put(1, 1);
        lruCacheJdkDemo.put(2, 2);
        lruCacheJdkDemo.put(3, 3);
        System.out.println(lruCacheJdkDemo.keySet());

        lruCacheJdkDemo.put(4, 1);
        System.out.println(lruCacheJdkDemo.keySet());

        lruCacheJdkDemo.put(3, 1);
        System.out.println(lruCacheJdkDemo.keySet());
        lruCacheJdkDemo.put(3, 1);
        System.out.println(lruCacheJdkDemo.keySet());
        lruCacheJdkDemo.put(3, 1);
        System.out.println(lruCacheJdkDemo.keySet());

        lruCacheJdkDemo.put(5, 1);
        System.out.println(lruCacheJdkDemo.keySet());
    }
}

/*
true
[1, 2, 3]
[2, 3, 4]
[2, 4, 3]
[2, 4, 3]
[2, 4, 3]
[4, 3, 5]
*/

/*
false
[1, 2, 3]
[2, 3, 4]
[2, 3, 4]
[2, 3, 4]
[2, 3, 4]
[3, 4, 5]
*/
