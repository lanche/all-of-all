package algorithm.jianzhiOffer;

import algorithm.model.ListNode;

/**
 * @author lanche
 * @Date 2020/11/2
 * @Description 输入两个链表，找出它们的第一个公共节点。
 */
public class FindFirstCommonNode {

    /**
     * 方法一，一个指针先跑多出来的距离
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int len1 = getLen(headA);
        int len2 = getLen(headB);

        ListNode curA = headA, curB = headB;
        if((len1 - len2) > 0) {
            for(int i = 0; i < len1 - len2; i++) {
                curA = curA.next;
            }
        } else {
            for(int i = 0; i < len2 - len1; i++) {
                curB = curB.next;
            }
        }
        while(curA != curB && curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }
        return (curA == null || curB == null) ? null : curA;

    }

    private int getLen(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    /**
     * 交叉跑法，最终要不相遇，要不同时到终点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA, curB = headB;
        while(curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }
        return curA;
    }
}
