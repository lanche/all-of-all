package algorithm.leetcode;

import algorithm.model.ListNode;

/**
 * @author lanche
 * @Date 2020/7/26
 * @Description
 */
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
public class ReverseList {

    /**
     * 迭代的方式实现
     * 几个关键点
     * 因为反转后，下一个节点的连接断开了，所以需要一个节点保存下一个节点（next）
     * 进行反转的时候无法再遍历到上一个节点，因此需要提前保存前一个节点（pre）
     * 将当前节点的下一个节点指向上一个节点后，需要将当前节点作为新的前一个节点，然后再将下一个节点作为当前节点
     * @param head
     * @return
     */
    public ListNode reverseListIterator(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
