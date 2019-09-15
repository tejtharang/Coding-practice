package com.tej.randomthings;

import java.util.HashMap;
import java.util.Map;

public class MapIteration {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        mapIteration(map);
    }

    public static void mapIteration(Map<Integer, Integer> map){
        map.forEach((key,value) -> {
            System.out.println(key + " and " + value);
        });
    }
}
