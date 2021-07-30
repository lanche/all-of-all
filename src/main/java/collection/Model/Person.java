package collection.Model;

/**
 * @author hezhensheng02
 * @date 2020/7/29 04:30
 * @description
 */

/**
 * lombok的Data注解自动重写了equals和hashCode方法
 */
public class Person {

    int age;

    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
