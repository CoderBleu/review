import java.util.Arrays;

/**
 * @author Lauy
 * @date 2021/2/18
 *
 * 升序排序
 */
public class AscendingOrder {

    //给数组升序排序
    private static int[] num = {28,25,5,8,13} ;

    public static void main(String[] args) {

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1; j++) {
                if (num[j + 1] < num[j]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(num));
    }
}
