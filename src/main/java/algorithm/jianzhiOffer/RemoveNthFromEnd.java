package algorithm.jianzhiOffer;

import algorithm.model.ListNode;

/**
 * @author lanche
 * @Date 2020/10/30
 * @Description 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 * 注意不是删除倒数第k个节点
 */
public class RemoveNthFromEnd {

    /**
     * 两次遍历法
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        ListNode cur = head;
        while(cur != null) {
            k--;
            cur = cur.next;
        }
        if(k < 0) {
            cur = head;
            while(++k != 0) {
                cur = cur.next;
            }
            head = cur.next;
        }
        return head;
    }

    /**
     * 双指针法
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if(head == null || k < 1) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && k != 0) {
            fast = fast.next;
            k--;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}
