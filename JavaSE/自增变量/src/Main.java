/**
 * @author coderblue
 * @date 2021/1/27
 */
public class Main {
    public static void main(String[] args) {
        int i = 1;
        // i++：先运算再加，等式左边 i 为 1，等式右边 i 运算后为 1+1=2
        i = i++;
        // i++：先运算再加，等式左边 i 为 1，等式右边 i 运算后为 1+1=2
        int j = i++;
        // 2 + 3 * 3
        // i开始等于2，然后++i后i等于3，再i++后i还是等于3
        int k = i + ++i * i++;
    }
}
