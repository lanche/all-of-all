package algorithm;

import algorithm.model.TreeNode;

import java.util.Stack;

/**
 * @author lanche
 * @Date 2020/7/8
 * @Description 判断一棵树是否为搜索树
 */
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索
// 👍 648 👎 0
public class IsValidBST {

    /**
     * 递归的方式，深度优先，将左节点（或者右节点）的值与当前节点的值作比较，判断是否满足搜索树的定义
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    private boolean help(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!help(node.left, lower, val)) {
            return false;
        }
        if (!help(node.right, val, upper)) {
            return false;
        }
        return true;
    }

    /**
     * 非递归中序遍历的方式，如果为搜索树则中序遍历的方式一定为升序的
     * @param root
     * @return
     */
    public boolean isValidBSTInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 保存前一个节点的值
        int inorder = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 判断当前节点的值是否比前一个节点小，如果是的话说明不是升序的，即不是搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
