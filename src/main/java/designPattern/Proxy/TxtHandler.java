package designPattern.Proxy;

/**
 * @author hezhensheng02
 * @date 2020/7/3 20:45
 * @description
 */
public class TxtHandler {

    public void process(Object o) {
        if (o instanceof String) {
            System.out.println("我是一个文本,内容有：" + o);
        }
    }

}
