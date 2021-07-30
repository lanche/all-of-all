package collection;

/**
 * @author lanche
 * @Date 2021/1/9
 * @Description
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("");
        String s2 = new String("");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String v1 = "hezhensheng";
        String v2 = "hezhensheng";

        System.out.println(v1 == v2);
        System.out.println(v1.equals(v2));
        System.out.println(v1 == "hezhensheng");

     }
}
