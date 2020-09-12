package others;

/**
 * 颠倒二进制位
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * 示例 2：
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *
 * @author liyaozong
 * @date 2020/9/11 9:53
 */
public class InvertedBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(00000000000000000000000000001011));
        System.out.println(reverseBits2(00000000000000000000000000001011));
    }

    /**
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++) {
            res = (res << 1) + (n&1);
            n >>= 1;
        }
        return res;
    }

    /**
     * 反转
     * 反转左右16位，然后反转每个16位中的左右8位，依次类推，最后反转2位，反转后合并即可，同时可以利用位运算在原地反转
     */
    public static int reverseBits2(int n) {
        // 原数字43261596
        // 0000 ‭0010 1001 0100 _ 0001 1110 1001 1100‬
        // 反转左右16位：
        // 0001 1110 1001 1100 _ 0000 0010 1001 0100‬
        n = (n >>> 16) | (n << 16);
        // 0xff00ff00 = 11111111 000000000 11111111 0000000000
        // 0x00ff00ff = 000000000 11111111 000000000 11111111
        // n和0xff00ff00想与 = 0001 1110 0000 0000 0000 0010 0000 0000 相当于消掉0-8 16-24位
        // 右移8位 0000 0000 0001 1110 0000 0000 0000 0010
        // n和0x00ff00ff想与 = 0000 0000 1001 1100 0000 0000 1001 0100 相当于消掉 8-16 24-32位
        // 左移8位 1001 1100 0000 0000 1001 0100 0000 0000
        // 两者求或则相当于两者相加 达到反转每8位进行一次反转的效果：
        // 1001 1100 0001 1110 _ 1001 0100 0000 0010
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        // 0xf0f0f0f0 = 1111 0000 1111 0000 1111 0000 1111 0000
        // 0x0f0f0f0f = 0000 1111 0000 1111 0000 1111 0000 1111
        // 两次相与可以每隔4位就消掉4位
        // 两者分别右移和左移4位之后，求或可以达到每4位进行一次反转的效果
        // 1100 1001 1110 0001 _ 0100 1001 0010 0000‬
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        // 0xcccccccc = 1100 1100 1100 1100 1100 1100 1100 1100
        // 0x33333333 = 0011 0011 0011 0011 0011 0011 0011 0011
        // 两次想与可以每隔2位就消掉2位
        // 两者分别右移和左移2位后，求或可以达到每2位进行一次反转的效果
        // 0011 0110 1011 0100 _ 0001 0110 1000 0000
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        // 0xaaaaaaaa = 1010 1010 1010 1010 1010 1010 1010 1010
        // 0x55555555 = 0101 0101 0101 0101 0101 0101 0101 0101
        // 两次想与可以每隔1位就消掉1位
        // 两者分别右移和左移1位后，求或可以达到每1位进行一次反转的效果
        // 0011 1001 0111 1000 _ 0010 1001 0100 0000‬‬
        // 完成反转
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

}