package algorithm.jianzhiOffer;

/**
 * @author lanche
 * @Date 2020/10/29
 * @Description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        if(s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
