package concurrence;

/**
 * @author hezhensheng02
 * @date 2020/7/11 07:24
 * @description
 */
public class UnsafeAdd {

    private long count = 0;

    public static void main(String[] args) throws Exception {
        final UnsafeAdd obj = new UnsafeAdd();

        Thread t1 = new Thread(
                obj::add10K
        );

        Thread t2 = new Thread(
                obj::add10K
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("累加20w之后的值为:" + obj.getCount());
    }

    public synchronized long getCount() {
        return count;
    }

    public synchronized void setCount(long count) {
        this.count = count;
    }

    void add10K() {
        int index = 0;
        while (index++ < 100000) {
            setCount(getCount() + 1);
        }
    }
}
