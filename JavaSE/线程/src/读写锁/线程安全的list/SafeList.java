package 读写锁.线程安全的list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Stream;

/**
 * @author Lauy
 * @date 2021/3/24
 */
public class SafeList<T extends Object> {

    private List<T> list = new ArrayList<T>();
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    // 添加数据
    public void add(T t) {
        writeLock.lock();
        try {
            list.add(t);
        } finally {
            writeLock.unlock();
        }
    }

    // 删除数据
    public void remove(T t) {
        writeLock.lock();
        try {
            list.remove(t);
        } finally {
            writeLock.unlock();
        }
    }

    // 获取数据
    public void get(int index) {
        readLock.lock();
        try {
            list.get(index);
        } finally {
            readLock.unlock();
        }
    }

}
