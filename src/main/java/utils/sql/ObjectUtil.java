package utils.sql;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.sun.istack.internal.Nullable;

import model.Person;

/**
 * @Author hezhensheng
 * @Date 2021/4/14
 * @Description
 */
public class ObjectUtil {

    /**
     * 判断一个对象是否有属性值为null，可用于对象之间转化、
     * 或者反射生成对象时的场景
     * @param obj
     * @return
     */
    public static boolean eitherFieldNull(Object obj) {
        return eitherFieldNull(obj, (String) null);
    }

    public static boolean eitherFieldNull(Object obj, @Nullable String ... ignoreField) {
        for(Field f : obj.getClass().getDeclaredFields()){
            if (needSkip(f.getName(), ignoreField)) {
                continue;
            }
            f.setAccessible(true);
            try {
                if(f.get(obj) == null){
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static boolean needSkip(String field, String ... ignoreField) {
        return ignoreField != null && Arrays.asList(ignoreField).contains(field);
    }



    public static void main(String[] args) throws IllegalAccessException{
        //System.out.println(eitherFieldNull(new Person("hezhensheng", 27)));
        Person person = new Person();
        person.setNumber(12);
        System.out.println(eitherFieldNull(person, "name"));

    }
}
