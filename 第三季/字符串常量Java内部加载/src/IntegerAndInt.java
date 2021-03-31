/**
 * @author Lauy
 * @date 2021/2/7
 */
public class IntegerAndInt {
    public static void main(String[] args) {
        Integer i1 = new Integer(12);
        Integer i2 = new Integer(12);
        System.out.println(i1 == i2); // false
        System.out.println(i1.equals(i2)); // true

        Integer i3 = 126;
        Integer i4 = 126;
        Integer.valueOf(126);
        int i5 = 126;
        System.out.println(i3 == i4); // true
        System.out.println(i3 == i5); // true，自动拆箱比较数值

        Integer i6 = 128;
        Integer i7 = 128;
        int i8 = 128;
        // static final int low = -128;
        // static final int high;
        System.out.println(i6 == i7); // false,超出了范围，相当于new Integer()
        System.out.println(i6 == i8); // true,有基本类型int，自动拆箱比较数值

    }
}
