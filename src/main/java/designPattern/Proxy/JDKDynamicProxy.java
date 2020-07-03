package designPattern.Proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hezhensheng02
 * @date 2020-06-02 16:38
 * @description
 */
@Slf4j
public class JDKDynamicProxy {

    public static void main(String[] args) {

        LogInvocationHandler handler = new LogInvocationHandler(new StringHandler());
        ClassLoader loader = StringHandler.class.getClassLoader();
        Class[] proxyInterface = new Class[] {Handler.class};
        log.info("jdk代理执行使用的类加载器:{}，接口:{}，被代理对象:{}", loader, proxyInterface, handler.toString());
        Handler proxy = (Handler)Proxy.newProxyInstance(loader, proxyInterface, handler);
        proxy.process("hello, I'm hezhensheng~");
    }

    private static class LogInvocationHandler implements InvocationHandler {

        private Object target;

        public LogInvocationHandler(Object object) {
            this.target = object;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("使用了jdk代理执行方法，代理的对象是{}，执行的方法是{}，参数是{}", target, method, args);
            Object result = method.invoke(target, args);
            log.info("代理执行的结果是:{}", result);
            return result;
        }
    }

    /**
     * Proxy的newProxyInstance方法核心代码：
     * 获取代理类
     * Class<?> cl = getProxyClass0(loader, intfs);
     * 获取带有InvocationHandler参数的构造方法
     * final Constructor<?> cons = cl.getConstructor(constructorParams);
     * 把Handler传入构造方法生成实例
     * cons.newInstance(new Object[]{h});
     */
}
