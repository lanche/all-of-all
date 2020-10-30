package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/10/30
 * @Description 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CuttingRope {

    /**
     * dp法
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        int[] dp = new int[n+1];
        if(n <= 3) return n-1;
        /*解决大问题的时候用到小问题的解并不是这三个数
        真正的dp[1] = 0,dp[2] = 1,dp[3] = 2
        但是当n=4时，4=2+2 2*2=4 而dp[2]=1是不对的
        也就是说当n=1/2/3时，分割后反而比没分割的值要小，当大问题用到dp[j]时，说明已经分成了一个j一个i-j，这两部分又可以再分，但是再分不能比他本身没分割的要小，如果分了更小还不如不分
        所以在这里指定大问题用到的dp[1],dp[2],dp[3]是他本身*/
        dp[1] = 1;dp[2] = 2;dp[3] = 3;
        for(int i = 4; i <= n; i++) {
            for(int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i],dp[i-j]*dp[j]);
            }
        }
        return dp[n];
    }


    /**
     * 数论法
     * 任何大于1的数都可由2和3相加组成（根据奇偶证明）
     * 因为2*2=1*4，2*3>1*5, 所以将数字拆成2和3，能得到的积最大
     * 因为2*2*2<3*3, 所以3越多积越大 时间复杂度O(n/3)，用幂函数可以达到O(log(n/3)), 因为n不大，所以提升意义不大，
     * 我就没用。 空间复杂度常数复杂度O(1)
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int div = n/3;
        int rem = n%3;
        long result = 1;
        for(int i=0; i < div; i++) {
            result *= i < div - 1 ? 3 : (rem == 2 ? 3*rem : (3 + rem));
            if (result >= 1000000007) {
                result = result%1000000007;
            }
        }
        return (int)result;
    }
}
