package algorithm;

import algorithm.model.ListNode;

/**
 * @author lanche
 * @Date 2020/7/7
 * @Description
 */
public class RemoveNthFromEnd {

    /**
     * 双指针法
     * 有个问题及时n大于链表长度时应该怎么返回？
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
