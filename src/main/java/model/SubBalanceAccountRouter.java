package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @Author hezhensheng
 * @Date 2021/4/20
 * @Description
 */
public class SubBalanceAccountRouter {
    private String outOrderNo;
    private long slot;
    private long createTime;
    private long updateTime;

    static Map<String, Integer> map = Maps.newConcurrentMap();

    public static void main(String[] args) throws InterruptedException {
        Map<String, List<String>> map = Maps.newConcurrentMap();
        map.put("hzs", Lists.newArrayList("he", "zhen", "sheng"));
        map.put("empty", Lists.newArrayList());
        map.put("gzc", Lists.newArrayList("ge", "zheng", "cui"));
        System.out.println(map);
        new Thread(() -> {
            for (int i = 0; i <100; i++) {
                map.put(String.valueOf(i), Lists.newArrayList("test"));
                System.out.println("map size:" + map.size());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        map.forEach((k, v) -> {
            System.out.println("k:" + k + ", v:" + v);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
/*        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()){
            String s = iter.next();
            if(s.equals("empty")){
                new Thread(() -> {
                    map.get("empty").add("not empty");
                }).start();
                Thread.sleep(3000);
                System.out.println(map);
                iter.remove();
            }
        }*/
        System.out.println(map);
        /*
        map.put("h", 1);
        map.put("z", 2);
        map.put("s", 3);
        System.out.println(map.size());
        map.keySet().removeIf(SubBalanceAccountRouter::needRemove);
*//*        map.forEach((k, v) -> {
            map.put(k, null);
        });*//*
        System.out.println(map);
        System.out.println(map.size());*/
    }

    private static boolean needRemove(String key) {
        return key.equals("z");
    }
}
