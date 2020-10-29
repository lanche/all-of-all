package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/10/29
 * @Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出
 * 旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 */
public class MinNumberInRotateArray {

    /**
     * 顺序遍历，碰到比第一个数小即为最小的数，否则第一个数即为最小的数
     * @param numbers
     * @return
     */
    public int minArray1(int[] numbers) {
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i] < numbers[0]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }


    /**
     * 二分法
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (numbers[mid] > numbers[right]) {
                // 注意这里要加一
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

}
