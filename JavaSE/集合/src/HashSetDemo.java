import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lauy
 * @date 2021/2/19
 */
public class HashSetDemo {
    public static void main(String[] args) {
        //增加
        Set<String> hashSet = new TreeSet<String>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("4");
        hashSet.add("3");
        hashSet.add("5");
        hashSet.add("-10");
        // hashSet.add(null);
        // hashSet.add(null);

        //删除
        hashSet.remove("1");

        //查询  无法获取某个元素
        System.out.println("是否包含1元素：" + hashSet.contains("2"));

        //迭代
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
