import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author Lauy
 * @date 2021/2/20
 */
public class Test {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null, null);
        objectObjectHashMap.put(null, null);

        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        // objectObjectHashtable.put(null, null); //不允许为空

        HashSet<Object> objects = new HashSet<>();
        objects.add(null);
        objects.add(null);

        short s1 = 1; s1 += 1;
        float f = 3.4F;
    }
}
