package concurrence.threadlocal;

/**
 * @author hezhensheng02
 * @date 2020/7/29 21:15
 * @description
 */
public class EntryValue {

    /**
     * 设置默认占用空间10M
     */
    int[] defMem = new int[1024 * 1024 * 100];

    @Override
    public String toString() {
        return "entry value:" + hashCode();
    }
}
