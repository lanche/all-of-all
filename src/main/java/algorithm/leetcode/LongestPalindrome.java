package algorithm.leetcode;

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
        int halfLen = len / 2;
        for (int i = 0; i < halfLen; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中心扩展法
     * 思路就是从第一个字符开始，包括字符间的间隙作为中心，两个指针同时往两边延伸，判断是否两个指针指向的字符是否
     * 为相同的字符
     *
     * @param s 输入的字符串，不为null
     * @return
     */
    public String longestPalindromeCenterSpread(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < len - 1; i++) {
            String s1 = centerSpread(s, i, i);
            String s2 = centerSpread(s, i, i + 1);
            String maxLenStr = s1.length() > s2.length() ? s1 : s2;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    /**
     * 中心扩展实现获取最长的回文字符串
     * left = right时回文串长度为奇数
     * left + 1 = right时回文串长度为偶数
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private String centerSpread(String s, int left, int right) {
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
