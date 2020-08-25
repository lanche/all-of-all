package algorithm.leetcode;

import algorithm.model.TreeNode;

/**
 * @author lanche
 * @Date 2020/7/8
 * @Description
 */
//给定一个二叉树，原地将它展开为一个单链表。
//
//
//
// 例如，给定二叉树
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Related Topics 树 深度优先搜索
// 👍 405 👎 0
public class Flatten {

    /**
     * 1.将原来的右子树接到左子树的最右节点
     * 2.将左子树插入到右子树
     * 3.继续下一个节点，直到新的右子树为null
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            // 左子树为null时直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找到左子树的最右节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将原来的右子树接到左子树的最右节点
                pre.right = root.right;
                // 将左子树接到右子树
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
}
