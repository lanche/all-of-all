package algorithm.jianzhiOffer;

import java.util.HashMap;

/**
 * @author lanche
 * @Date 2020/11/2
 * @Description 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    /**
     * https://www.yuque.com/hezhensheng/gt485o/tlw2v6
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        char[] strArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        for(; end < strArray.length; end++) {
            if(map.containsKey(strArray[end])) {
                start = Math.max(map.get(strArray[end]) + 1, start);
            }
            map.put(strArray[end], end);
            max = Math.max(end - start, max);
        }
        // 处理空字符串的情况
        return end == 0 ? 0 : max + 1;
    }

}
