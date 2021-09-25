package concurrence.twoThreadPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author hezhensheng
 * @Date 2021/5/19
 * @Description
 */
public class LockConditionPrint {
    private static Thread t1, t2;
    private static volatile int count = 0;
    private static volatile boolean isOu = false;
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                try {
                    if (isOu) {
                        condition1.wait();
                    }
                    System.out.println(String.format("treane name:%s, A", Thread.currentThread().getName()));
                    count++;
                    isOu = true;
                    condition2.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            }
        });

        t2 = new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                try {
                    if (!isOu) {
                        condition2.wait();
                    }
                    System.out.println(String.format("treane name:%s, B", Thread.currentThread().getName()));
                    count++;
                    isOu = false;
                    condition1.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
