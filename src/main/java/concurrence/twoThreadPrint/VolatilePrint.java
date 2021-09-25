package concurrence.twoThreadPrint;

/**
 * @Author hezhensheng
 * @Date 2021/5/19
 * @Description 交替打印奇偶数
 */
public class VolatilePrint {

    private static volatile int num = 0;
    private static volatile boolean isOu = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num <= 100) {
                if (isOu) {
                    System.out.println(String.format("treane name:%s, num:%d", Thread.currentThread().getName(), num));
                    num++;
                    isOu = false;
                }
            }
        }).start();

        new Thread(() -> {
            while (num <= 100) {
                if (!isOu) {
                    System.out.println(String.format("treane name:%s, num:%d", Thread.currentThread().getName(), num));
                    num++;
                    isOu = true;
                }
            }
        }).start();
    }
}
