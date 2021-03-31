import java.util.Arrays;

/**
 * @author Lauy
 * @date 2021/1/28
 */
public class Main {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();

        change(i, str, num, arr, my);

        // arr my变了
        System.out.println("i= " + i);
        System.out.println("str= " + str);
        System.out.println("num= " + num);
        System.out.println("arr= " + Arrays.toString(arr));
        System.out.println("my.a= " + my.a);

    }

    /**
     * String、包装类等对象的不可变性 final
     *
     * 方法的参数传递机制
     * 1、形参是基本数据类型
     * 传递数据值
     * 2、实参是引用数据类型
     * 传递地址值,且与传的入参地址值不同
     */
    public static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}
