package algorithm.jianzhiOffer;

import algorithm.model.ListNode;

/**
 * @author lanche
 * @Date 2020/10/29
 * @Description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        int[] nums = new int[count];
        cur = head;
        for(int i = count-1; i >= 0; i--) {
            nums[i] = cur.val;
            cur = cur.next;
        }
        return nums;
    }
}
