package model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author hezhensheng
 * @Date 2021/1/17
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends Person{
    public Student() {
    }

    public Student(String name, int num) {
        super(name, num);
    }

    @Override
    public String toString(){
        return "name:" + name + ",num:" + number;
    }

    @Override
    public void say() {
        System.out.println("a student");
    }

    public void run() {
        super.handle();
    }
}
