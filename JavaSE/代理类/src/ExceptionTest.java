/**
 * @author Lauy
 * @date 2021/3/13
 */
public class ExceptionTest {
    public static void main(String[] args) {
        test1();
        error();
        test1();
    }

    public static void test1() {
        System.out.println("正常-test1");
    }

    public static void error()  throws ArithmeticException{
            int i = 1 /0;
        System.out.println("错误");
    }

}
