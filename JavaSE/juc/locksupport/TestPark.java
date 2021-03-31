package locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Lauy
 * @date 2021/3/23
 */
public class TestPark {
    public void  testPark() {
        LockSupport.park(); // (1)
    }

    public static void main(String[] args) {
        TestPark testPark = new TestPark();
        testPark.testPark();
    }
}
