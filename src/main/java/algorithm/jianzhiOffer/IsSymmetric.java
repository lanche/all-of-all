package algorithm.jianzhiOffer;

import algorithm.model.TreeNode;

/**
 * @author lanche
 * @Date 2020/10/31
 * @Description 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val && help(left.left, right.right) && help(left.right, right.left);
    }

}
