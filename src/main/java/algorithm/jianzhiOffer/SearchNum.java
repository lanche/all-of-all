package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/11/2
 * @Description 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 */
public class SearchNum {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        int count = 0;
        while(left < right) {
            int mid = (left + right)/2;
            if(nums[mid] >= target) {
                right = mid;
            } else {
                // 注意加一
                left = mid + 1;
            }
        }
        while(left < nums.length && nums[left++] == target) {
            count++;
        }
        return count;
    }

}
