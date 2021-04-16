package funcation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import model.Person;
import model.Student;

/**
 * @Author hezhensheng
 * @Date 2021/1/17
 * @Description
 */
public class FuncationalInterfaceTest {

    static List<Student> list = Arrays.asList(new Student("zhangsan", 80), new Student("lisi", 90), new Student("wangwu", 98));

    public static void main(String[] args) {

        FuncationalInterfaceTest run = new FuncationalInterfaceTest();
        run.consumer(list, student -> student.setNumber(100));
        list.forEach(student -> System.out.println(student.toString()));

        Student student = new Student();
        Person person = student;

    }

    public <E> void consumer(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }
}
