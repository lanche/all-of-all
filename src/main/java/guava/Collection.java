package guava;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @Author hezhensheng
 * @Date 2021/4/2
 * @Description
 */
public class Collection {
    public static void main(String[] args) {
        List<List<Integer>> parts = Lists.partition(initData(), 200);
        parts.forEach(list -> {
            System.out.println(list.size());
            System.out.println(list);
        });
    }


    private static List<Integer> initData() {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        return list;
    }
}
