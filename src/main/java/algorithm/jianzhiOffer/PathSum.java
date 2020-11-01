package algorithm.jianzhiOffer;

import algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lanche
 * @Date 2020/11/1
 * @Description 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        findPath(root, target);
        return res;
    }

    public void findPath(TreeNode root, int target) {
        if(root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) {
            // 注意要新建一个对象，防止对象后面被修改
            res.add(new LinkedList(path));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        // 返回上层时需要删除最后一个节点
        path.removeLast();
    }
}
