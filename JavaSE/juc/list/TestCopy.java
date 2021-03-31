package list;

import java.util.Arrays;

/**
 * @author Lauy
 * @date 2021/3/23
 */
public class TestCopy {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 7};
        int len = arr.length;

        int[] newArr = new int[len - 1];
        int index = 2;
        System.arraycopy(arr, 0, newArr, 0, index);
        System.out.println(Arrays.toString(newArr));

        System.arraycopy(arr, index + 1, newArr, index, len - index - 1);
        System.out.println(Arrays.toString(newArr));
    }
}
