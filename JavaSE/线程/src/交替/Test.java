package 交替;

/**
 * @author Lauy
 * @date 2021/3/17
 */
public class Test {
    public static void main(String[] args) {
        PrintClass printClass = new PrintClass();

        for (int i = 0; i < 5; i++) {
            ThreadA threadA = new ThreadA(printClass);
            ThreadB threadB = new ThreadB(printClass);

            threadA.start();
            threadB.start();
        }
    }
}
