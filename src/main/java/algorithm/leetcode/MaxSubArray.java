package algorithm.leetcode;

/**
 * @author hezhensheng02
 * @date 2020/7/6 02:19
 * @description
 */
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
public class MaxSubArray {

    /**
     * 普通解法，一次遍历，时间复杂度为n，空间复杂度为1
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int curValue = 0;
        for (int num : nums) {
            curValue += num;
            maxValue = Math.max(curValue, maxValue);
            curValue = Math.max(curValue, 0);
        }
        return maxValue;
    }

}
