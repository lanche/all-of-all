package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/11/2
 * @Description 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        if(s == null || s.length() == 0) return ' ';
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }
        return ' ';
    }

}
