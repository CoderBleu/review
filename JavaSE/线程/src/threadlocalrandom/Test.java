package threadlocalrandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Lauy
 * @date 2021/3/22
 */
public class Test {
    public static void main(String[] args) {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();

        for (int i = 0; i < 5; i++) {
            System.out.println(localRandom.nextInt(10));
        }
        int a = 3; int b = 2;
        System.out.println(a &= b);
    }
}
