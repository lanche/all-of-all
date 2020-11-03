package algorithm.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanche
 * @Date 2020/11/1
 * @Description 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 */
public class MinNumber {

    /**
     * 重写比较方法，对字符串数组排序然后拼接成字符串
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<String>();
        for(int el : nums) {
            list.add(String.valueOf(el));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }


    public String printMinNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        int len = nums.length;
        String[] strArray = new String[len];
        for (int i = 0; i < len; i++) {
            strArray[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArray, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder str = new StringBuilder();
        for (String el : strArray) {
            str.append(el);
        }
        return str.toString();
    }
}
