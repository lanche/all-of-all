package algorithm;

import com.sun.tools.javac.util.Assert;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

/**
 * @author hezhensheng02
 * @date 2020/6/25 19:49
 * @description 最长回文字符串
 */
public class LongestPalindrome {

    /**
     * 暴力解法
     * 枚举出所有的字符串，然后根据回文的规则判断
     * @param s
     * @return
     */
    public String longestPalindromeViolence(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<=len; j++) {
                String test = s.substring(i, j);
                if (test.length() > max && isPalindromic(test)) {
                    ans = test;
                    max = test.length();
                }
            }
        }
        return ans;
    }

    /**
     * 如果一个字符串是回文字符串，那么两个下标和为字符串长度-1的两个字符一样
     * @param str
     * @return
     */
    private boolean isPalindromic(String str) {
        int len = str.length();
        int halfLen = len/2;
        for (int i=0; i<halfLen; i++) {
            if (str.charAt(i) != str.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }
}
