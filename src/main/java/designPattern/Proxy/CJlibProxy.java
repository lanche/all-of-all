package designPattern.Proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hezhensheng02
 * @date 2020/7/3 21:21
 * @description
 */
@Slf4j
public class CJlibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // cjlib原理为动态生成子类，所以需要设置父类，即原来的类
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        // 创建代理
        return enhancer.create();

    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.nanoTime();
        Object result = methodProxy.invokeSuper(o, objects);
        long end = System.nanoTime();
        log.info("执行耗时:{}ps", (end - start)/1000);
        return result;
    }
}
