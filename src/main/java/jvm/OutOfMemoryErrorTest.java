package jvm;

import model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hezhensheng
 * @Date 2021/1/12
 * @Description
 */
public class OutOfMemoryErrorTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        while (true) {
            list.add(new Person());
        }
    }
}
