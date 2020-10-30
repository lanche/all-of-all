package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/10/30
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数
 * 和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    /**
     * 双指针法，分表从首尾开始遍历，然后交换
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            while(nums[left]%2 == 1 && left < right) {
                left++;
            }
            while(nums[right]%2 == 0 && right > left) {
                right--;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
