package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/11/1
 * @Description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 */
public class VerifySquenceOfBST {

    /**
     * 序列的最后一个元素是二叉搜索树的根节点。
     *
     * 在序列中从左到右找到根节点的左子树(比根节点小)、右子树(比根节点大)。
     *
     * 如果右子树中出现比根节点小的元素，那么为 false。
     * 否则递归左右子树。
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length < 1) {
            return true;
        }
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] postorder, int start, int end) {
        if(start >= end) {
            return true;
        }
        int val = postorder[end];
        int i = start;
        while(i <= end) {
            if(postorder[i] >= val) {
                break;
            }
            i++;
        }
        for(int j = i; j < end; j++) {
            if(postorder[j] < val) {
                return false;
            }
        }
        return verify(postorder, start, i - 1) && verify(postorder, i, end - 1);
    }
}
