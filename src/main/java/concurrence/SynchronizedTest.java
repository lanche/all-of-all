package concurrence;

import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * @Author hezhensheng
 * @Date 2021/4/27
 * @Description 证明synchronized是可重入的
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                test.test1();
            }
        }.start();

        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                test.test2();
            }
        }.start();
        System.out.println(TimeUnit.SECONDS.toMillis(1L));
    }

    private synchronized void test1() throws InterruptedException {
        System.out.println("test1~");
        Thread.sleep(5000);
    }

    private synchronized void test2() throws InterruptedException {
        System.out.println("test2~");
        Thread.sleep(5000);
    }
}
