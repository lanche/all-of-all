package jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author hezhensheng
 * @Date 2021/1/13
 * @Description
 */
public class RuntimeConstantPoolOOM {

    /**
     * 执行结果
     * java.lang.OutOfMemoryError: Java heap space
     * 说明字符串常量池在堆上
     * @param args
     */
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
/*        while (true) {
            // intern方法返回的是常量池中对象的引用
            set.add(String.valueOf(i++).intern());
        }*/

        constantPoolTest();
    }


    private static void constantPoolTest(){
        String s1 = new StringBuilder("计算机").append("软件").toString();
        /**
         * jdk7以上结果为true，因为字符串常量池已经在堆中，因此字符串常量池指向的也是堆中的对象，
         */
        System.out.println(s1.intern() == s1);

        /**
         * "java"这个字符串在StringBuilder的toString方法之前已经出现，也就是之前已经有一个Java对象（常量池中也有引用），
         * 后来通过builder又创建了一个“Java”对象，两个对象地址不一样
         */
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
