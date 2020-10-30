package algorithm.jianzhiOffer;

import algorithm.model.ListNode;

/**
 * @author lanche
 * @Date 2020/10/30
 * @Description 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 */
public class DeleteNode {

    /**
     * 使用哑结点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode1(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }


    /**
     * 不用哑结点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        if (cur.val == val) {
            return head.next;
        }
        while(cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if(cur.next.val == val) {
            cur.next = cur.next.next;
        }
        return head;
    }
}
