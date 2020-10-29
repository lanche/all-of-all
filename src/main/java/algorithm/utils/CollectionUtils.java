package algorithm.utils;

/**
 * @author lanche
 * @Date 2020/10/29
 * @Description
 */
public class CollectionUtils {

    /**
     * 数组元素交换
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
