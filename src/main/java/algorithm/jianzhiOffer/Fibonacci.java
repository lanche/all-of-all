package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/10/29
 * @Description 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fibonacci {

    public int fib(int n) {
        if(n < 2) {
            return n;
        }
        int pre1 = 0;
        int pre2 = 1;
        for(int i = 1; i < n; i++) {
            pre2 = pre1 + pre2;
            pre1 = pre2 - pre1;
            pre2 %= 1000000007;
        }
        return pre2;
    }

}
