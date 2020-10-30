package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/10/30
 * @Description 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class NumberOf1 {

    /**
     * 利用整数 1，依次左移每次与 n 进行与运算，若结果不为0，说明这一位上数字为 1，++cnt。
     *
     * 此解法 i 需要左移 32 次。
     *
     * 不要用 n 去右移并与 1 进行与运算，因为n 可能为负数，右移时会陷入死循环。
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        int i = 1;
        while(i != 0) {
            if((n & i) != 0) {
                count++;
            }
            i <<= 1;
        }
        return count;
    }


    /**
     * 运算 (n - 1) & n，直至 n 为 0。运算的次数即为 n 的二进制中 1 的个数。
     * 因为 n-1 会将 n 的最右边一位 1 改为 0，如果右边还有 0，则所有 0 都会变成 1。结果与 n 进行与运算，会去除掉最右边的一个1。
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while( n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
