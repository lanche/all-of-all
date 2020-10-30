package algorithm.jianzhiOffer;

import algorithm.model.TreeNode;

/**
 * @author lanche
 * @Date 2020/10/30
 * @Description 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 */
public class IsSubStructure {

    /**
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null ) {
            return false;
        }
        // 递归判断当前节点和左右子节点是否满足条件
        return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        // 为null代表b遍历结束了，满足条件了
        if(b == null) {
            return true;
        }

        if(a == null || a.val != b.val) {
            return false;
        }

        // 因为是子树，左右节点应该一样
        return isSame(a.left, b.left) && isSame(a.right, b.right);

    }
}
