package concurrence.twoThreadPrint;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author hezhensheng
 * @Date 2021/5/19
 * @Description
 */
public class LockSupportPrint {

    private static Thread t1, t2;
    private static volatile int count = 0;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            while (count <= 100) {
                System.out.println(String.format("treane name:%s, A", Thread.currentThread().getName()));
                LockSupport.unpark(t2);
                count++;
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            while (count <= 100) {
                LockSupport.park();
                System.out.println(String.format("treane name:%s, B", Thread.currentThread().getName()));
                count++;
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
