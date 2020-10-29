package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/10/29
 * @Description 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumberIn2DArray {

    /**
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 ) {
            return false;
        }
        int arrayLen = matrix.length;
        int len = matrix[0].length;
        int i = arrayLen - 1;
        int j = 0;
        while(i >= 0 && j < len) {
            if(matrix[i][j] > target) {
                i--;
            } else if(matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
