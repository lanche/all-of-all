package designPattern.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hezhensheng02
 * @date 2020/7/3 20:45
 * @description
 */
public class CjlibDynamicProxy {

    public static void main(String[] args) {
        CjlibTxtHandler cjlibTxtHandler = new CjlibTxtHandler();
        TxtHandler txtHandler = (TxtHandler) cjlibTxtHandler.getInstance(new TxtHandler());
        txtHandler.process("我是通过cjlib代理产生的");
        new TxtHandler().process("我是自己产生的");
    }


    private static class CjlibTxtHandler implements MethodInterceptor {

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

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("有代理");
            methodProxy.invokeSuper(o, objects);
            System.out.println("代理结束了");
            return null;
        }
    }
}
