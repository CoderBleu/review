/**
 * @author Lauy
 * @date 2021/1/28
 */
public class Main {
    static int s;// 5
    int i; // 只定义并没有赋值
    int j;//A-1 B-1

    // 在非静态代码块中给 j 和 s 赋值了
    {
        int i = 1;
        // 就近原则：给局部变量 i 赋值
        i++;
        j++;
        s++;
    }

    public void test(int j) {
        j++; // 就近原则 21
        i++;
        s++;
    }

    public static void main(String[] args) {
        Main obj1 = new Main();
        Main obj2 = new Main();
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        // 2 1 5
        System.out.println(obj1.i + "," + obj1.j + "," + Main.s);
        // 1 1 5
        System.out.println(obj2.i + "," + obj2.j + "," + Main.s);
    }
}
