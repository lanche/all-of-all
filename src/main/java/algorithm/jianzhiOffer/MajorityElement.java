package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/11/1
 * @Description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class MajorityElement {

    /**
     * 投票法，相等的加一票，不等的减一票，统计数等于0时将当前数作为新的基数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int card = 0;
        int count = 0;
        for(int el : nums) {
            if(count == 0) {
                card = el;
            }
            if(el == card) {
                count++;
            } else {
                count--;
            }
        }
        return card;
    }

}
