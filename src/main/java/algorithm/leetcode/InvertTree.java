package algorithm.leetcode;

import algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hezhensheng02
 * @date 2020/7/10 00:40
 * @description
 */
//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树
public class InvertTree {

    /**
     * 递归的方式
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTreeRecursive(root.left);
        TreeNode right = invertTreeRecursive(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }
}
