package concurrence.twoThreadPrint;

/**
 * @Author hezhensheng
 * @Date 2021/5/19
 * @Description
 */
public class SynchronizedPrint {
    private static Thread t1, t2;
    private static volatile int count = 0;
    static Object lock = new Object();

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(String.format("treane name:%s, A", Thread.currentThread().getName()));
                    count++;
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2 = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(String.format("treane name:%s, B", Thread.currentThread().getName()));
                    count++;
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
