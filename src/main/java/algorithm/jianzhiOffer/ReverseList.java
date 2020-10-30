package algorithm.jianzhiOffer;

import algorithm.model.ListNode;

/**
 * @author lanche
 * @Date 2020/10/14
 * @Description 反转链表
 */
public class ReverseList {

    /**
     * 反转单向链表
     * @param head
     * @return
     * 1、先初始化一个前节点（pre）和后节点（next）变量
     * 2、先将当前节点（head）的下一个节点赋值给next变量，保证链表反转后下一个节点还可以访问
     * 3、再将前节点（pre）设置为当前节点的下一个节点（进行反转）
     * 3、反转之后需要将当前节点（head）设置为前节点（pre），之前保存的下一个节点（next）赋值给当前节点（head）
     * 4、返回前节点（pre），最后肯定是最后一个节点变为了pre节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
