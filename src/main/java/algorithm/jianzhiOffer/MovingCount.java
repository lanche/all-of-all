package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/10/30
 * @Description 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，
 * 机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class MovingCount {

    /**
     * 深度优先搜索，思路与字符数组中查找指定单词类似
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    /**
     *
     * @param i 当前点的横坐标
     * @param j 当前点的纵坐标
     * @param m
     * @param n
     * @param k
     * @param visited 数组中的元素是否被访问的标记
     * @return
     */
    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if(i >= m || i < 0 || j >= n || j < 0 || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j] == true) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i-1, j, m, n, k, visited) + dfs(i+1, j, m, n, k, visited) + dfs(i, j-1, m, n, k, visited) + dfs(i, j+1, m, n, k, visited) + 1;
    }
}
