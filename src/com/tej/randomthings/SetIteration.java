package com.tej.randomthings;

import java.util.HashSet;
import java.util.Set;

public class SetIteration {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        setIteration(set);
    }

    public static void setIteration(Set<Integer> set){
        set.forEach((value) -> {
            System.out.println(value);
        });
    }
}
