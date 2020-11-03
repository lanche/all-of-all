package algorithm.jianzhiOffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author lanche
 * @Date 2020/11/1
 * @Description 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 */
public class GetLeastNumbers {

    /**
     * 使用大顶堆
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for(int el : arr) {
            if(heap.size() < k) {
                heap.offer(el);
            } else {
                if(heap.peek() > el) {
                    heap.poll();
                    heap.offer(el);
                }
            }
        }
        int[] res = new int[heap.size()];
        int index = 0;
        for(int el : heap) {
            res[index++] = el;
        }
        return res;
    }
}
