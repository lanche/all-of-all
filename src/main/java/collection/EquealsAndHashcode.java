package collection;

import collection.Model.Person;

/**
 * @author hezhensheng02
 * @date 2020/7/29 04:30
 * @description 测试equals方法和hashCode方法
 */
public class EquealsAndHashcode {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person(1, "张三");
        Person p2 = new Person(1, "张三");
        // lombok的Data注解自动重写了equals和hashCode方法，使用注解与否影响了最终的结果
        // 重写equals方法的时候需要重写hashCode方法保证了对象相同的时候其hashCode值一样
        System.out.println("p1 hashcode:" + p1.hashCode() + ", p2 hashcode:" + p2.hashCode());
        System.out.println("p1 equals p2:" + p1.equals(p2));
        while (true) {
            Thread.sleep(1000);
        }
    }
}
