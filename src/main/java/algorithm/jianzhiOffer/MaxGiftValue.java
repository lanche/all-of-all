package algorithm.jianzhiOffer;

import java.util.HashMap;

/**
 * @author lanche
 * @Date 2020/11/2
 * @Description
 */
public class MaxGiftValue {

    /**
     * 题解同矩形的最短路径，dp问题
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        // 设置第一列数据
        for(int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        HashMap map = new HashMap();

        // 设置第一行数据
        for(int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }
}
