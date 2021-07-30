package algorithm.model

import java.util.stream.Collectors
import java.util.stream.IntStream

/**
 * @author lanche\
 * @Date 2020/7/7
 * @Description
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode getNodeList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null
        }
        List<ListNode> nodeList = list.stream()
                .map({ e -> new ListNode(e) })
                .collect(Collectors.toList())
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1)
        }
        return nodeList.get(0)
    }

    static void printlnNode(ListNode head) {
        ListNode cur = head
        while (cur != null) {
            println(cur)
            cur = cur.next
        }
    }

    static void main(String[] args) {
        List<Integer> list = new ArrayList<>()
        IntStream.range(0, 10).forEach({ i -> list.add(i) })
        println(list)
        ListNode head = getNodeList(list)
        printlnNode(head)
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
