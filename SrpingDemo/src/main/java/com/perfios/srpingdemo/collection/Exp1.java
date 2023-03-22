package com.perfios.srpingdemo.collection;

import java.util.*;

public class Exp1 {
    public static void main(String[] args) {

        List<String> data = new ArrayList<>();
        Collections.addAll(data,"Pramod","pavan","aditya","pratik","umar");

        data.stream().forEach(System.out::println);

        Map<Integer,String> map = new HashMap<>();

        map.put(1,"Pramod");
        map.put(2,"Pavan");
        map.put(3,"Aditya");

        map.entrySet().stream().forEach(i-> System.out.println(i.getKey()+" "+i.getValue()));

        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println("key:"+entry.getKey()+", value:"+entry.getValue());
        }
    }
}
