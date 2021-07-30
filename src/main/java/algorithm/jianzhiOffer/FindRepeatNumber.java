package algorithm.jianzhiOffer;

import algorithm.utils.CollectionUtils;

/**
 * @author lanche
 * @Date 2020/10/29
 * @Description 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也
 * 不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class FindRepeatNumber {

    /*

     */

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    CollectionUtils.swap(nums, i, nums[i]);
                }
            }
        }
        return 0;
    }


}
