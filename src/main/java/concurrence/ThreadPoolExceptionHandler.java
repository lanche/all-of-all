package concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hezhensheng02
 * @date 2020/7/16 19:58
 * @description
 */
public class ThreadPoolExceptionHandler {

    private static final ExecutorService threadPool =
            new ThreadPoolExecutor(4, 8, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100));

}
