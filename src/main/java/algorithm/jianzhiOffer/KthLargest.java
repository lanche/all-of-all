package algorithm.jianzhiOffer;

import algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanche
 * @Date 2020/11/2
 * @Description 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 */
public class KthLargest {


    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        help(root, list);
        return list.get(list.size() - k);
    }

    /**
     * 中序遍历
     * @param root
     * @param list
     */
    private void help(TreeNode root, List<Integer> list) {
        if(root == null) return;
        help(root.left, list);
        list.add(root.val);
        help(root.right, list);
    }
}
