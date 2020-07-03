package designPattern.Proxy;

/**
 * @author hezhensheng02
 * @date 2020/7/3 18:37
 * @description
 */
public class StringHandler implements Handler {

    public void process(Object o) {
        if (o instanceof String) {
            System.out.println("我是一个字符串,名字叫做" + o);
        }
    }
}
