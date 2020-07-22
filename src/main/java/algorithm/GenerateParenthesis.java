package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanche
 * @Date 2020/7/23
 * @Description
 */
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
public class GenerateParenthesis {

    /**
     * 深度优先解法
     * @param n
     * @return
     */
    public List<String> dfsGenerateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;

    }

    /**
     *
     * @param curStr 当前递归得到的结果
     * @param left 还可以使用的左括号的数目
     * @param right 还可以使用的右括号的数目
     * @param res 结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        if (left == 0 && right == 0) {
            res.add(curStr);
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }

    }
}
