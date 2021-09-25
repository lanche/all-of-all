package concurrence;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import model.Result;

/**
 * @author hezhensheng02
 * @date 2020/7/16 19:58
 * @description
 */
public class ThreadPoolExceptionHandler {

    protected static final Logger logger = LoggerFactory.getLogger(ThreadPoolExceptionHandler.class);

    private static final ExecutorService threadPool = new ForkJoinPool(4);

    public static void main(String[] args) {
         AtomicInteger count = new AtomicInteger();
        AtomicInteger result = handleAndGet(() -> {
            logger.info("count:{}", count.get());
            count.addAndGet(2);
        });
        System.out.println(count.get());
    }

    public static String test(String str) {
        return str;
    }

    public static <T> T handleAndGet(Runnable runnable) {
        List<Integer> integers = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }
        Result<T> re = new Result<>();
        integers.parallelStream().forEach(e -> {
            try {
                threadPool.submit(runnable).get();
                Thread.sleep(2000);
            } catch (Exception ex) {

            }
        });
        return re.getT();
    }

}
