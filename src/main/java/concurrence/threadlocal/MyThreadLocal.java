package concurrence.threadlocal;

/**
 * @author hezhensheng02
 * @date 2020/7/29 21:10
 * @description
 */
public class MyThreadLocal<T> extends ThreadLocal<T> {

    /**
     * 设置默认占用空间100M
     */
    int[] defMem = new int[1024 * 1024 * 100];
}
