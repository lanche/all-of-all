package concurrence.threadlocal;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hezhensheng02
 * @date 2020/7/29 22:00
 * @description
 */
@Slf4j
public class ThreadLocalTest2 {

    public static void main(String[] args) {

        new Thread(() -> {
            ThreadLocal<EntryValue> threadLocal = new ThreadLocal<>();
            {
                threadLocal.set(new EntryValue());
                System.out.println(threadLocal.get());
                //threadLocal = null;
            }

            threadLocal.remove();

            while (true) {
                try {
                    Thread.sleep(1000);
                    int[] a = new int[1024 * 1024 * 10];
                } catch (InterruptedException e) {
                    log.info("intrupt:", e);
                }
            }
        }).start();

    }

}
