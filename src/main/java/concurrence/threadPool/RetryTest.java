package concurrence.threadPool;

/**
 * @Author hezhensheng
 * @Date 2021/5/13
 * @Description 线程池ThreadPoolExecutor中有类似的用法
 */
public class RetryTest {
    public static void main(String[] args) {
        retry:
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break retry;
            }
            System.out.println(i);
        }
    }
}
