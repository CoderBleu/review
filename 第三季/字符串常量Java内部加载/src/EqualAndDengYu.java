import java.util.Objects;

/**
 * @author Lauy
 * @date 2021/2/7
 *
 * 1. new ("blue")不相等，会各自在堆空间创建
 * 2. 常量比较相等
 * 3. 常量 + 常量还是在常量池
 * 4. 对象 + 对象 != 对象，但是重写equals值相等 或者 用final修饰
 */
public class EqualAndDengYu {
    public static void main(String[] args) {
        String s1 = new String("blue");
        String s2 = new String("blue");
        System.out.println(s1 == s2); // false
        System.out.println(Objects.equals(s1, s2)); // true
        String s3 = "blue";
        String s4 = "blue";
        System.out.println(s3 == s4); // true
        System.out.println(s3 == s1); // false
        String s5 = "blueblue";
        String s11 = "blue" + "blue";
        String s6 = s3 + s4;
        System.out.println(s5 == s6); // false
        final String s7 = "blue";
        final String s8 = "blue";
        String s9 = s7 + s8;
        System.out.println(s5 == s9); // true
        final String s10 = s3 + s4;
        System.out.println(s5 == s10); // false
    }
}
