/**
 * @author Lauy
 * @date 2021/2/18
 */
public class BreakDemo {
    public static void main(String[] args) {
        /*跳出当前循环*/
        int x = 1; // 定义变量x，初始值为1
        while (x <= 4) { // 循环条件
            System.out.println("x = " + x); // 条件成立，打印x的值
            if (x == 3) {
                break;
            }
            x++; // x进行自增
        }

        /*跳出多层循环*/
        int i, j; // 定义两个循环变量
        Loop: for (i = 1; i <= 9; i++) { // 外层循环
            for (j = 1; j <= i; j++) { // 内层循环
                if (i > 4) { // 判断i的值是否大于4
                    break Loop; // 跳出外层循环
                }
                System.out.print("*"); // 打印*
            }
            System.out.print("\n"); // 换行
        }
    }
}
