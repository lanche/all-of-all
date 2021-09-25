package jvm.classLoader;

import model.Person;

/**
 * @Author hezhensheng
 * @Date 2021/1/15
 * @Description
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        Person person = new Person();
        ClassLoader loader = person.getClass().getClassLoader();
        while (loader != null) {
            System.out.println(loader.getClass().getName());
            loader = loader.getParent();
        }
        // 因为String的classLoad为BootStrap ClassLoader，返回值为null
        System.out.println(String.class.getClassLoader());
    }
}
