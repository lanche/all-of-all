package algorithm.jianzhiOffer;

import algorithm.model.TreeNode;

/**
 * @author lanche
 * @Date 2020/11/2
 * @Description 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 */
public class IsBalanced {

    /**
     * 递归判断左右子节点的高度差
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

/*
    private boolean isBalanced;

    *//**
     * 判断是否是平衡二叉树
     *
     * @param root 二叉树根结点
     * @return 是否是平衡二叉树
     *//*
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        isBalanced = true;
        treeDepth(root);
        return isBalanced;
    }

    private int treeDepth(TreeNode root) {
        if (root == null || !isBalanced) {
            return 0;
        }
        int lDepth = treeDepth(root.left);
        int rDepth = treeDepth(root.right);
        if (Math.abs(lDepth - rDepth) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(lDepth, rDepth);

    }*/

}
