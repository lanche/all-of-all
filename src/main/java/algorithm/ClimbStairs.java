package algorithm;

/**
 * @author hezhensheng02
 * @date 2020/7/5 11:27
 * @description
 */
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
public class ClimbStairs {

    /**
     * 暴力解法，未做优化
     *
     * @param n
     * @return
     */
    public int recursiveNoOptimization(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return recursiveNoOptimization(n - 1) + recursiveNoOptimization(n - 2);
    }

    int[] mem;

    /**
     * 借助于数组保存已计算的结果，解决重复计算的问题
     * 也可以用hashmap来保存结果，但是数组相对更省空间，且定位更快
     *
     * @param n
     * @return
     */
    public int recursiveWithOptimization(int n) {
        mem = new int[n + 1];
        return recursiveWithOptimizationImpl(n);
    }

    private int recursiveWithOptimizationImpl(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (mem[n] == 0) {
            mem[n] = recursiveNoOptimization(n - 1) + recursiveNoOptimization(n - 2);
        }
        return mem[n];
    }

    /**
     * 动态规划的解法
     *
     * @param n
     * @return
     */
    public int dpWithArray(int n) {
        mem = new int[n + 1];
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }

    /**
     * 动态规划的解法
     *
     * @param n
     * @return
     */
    public int dpWithoutArray(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = r; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
