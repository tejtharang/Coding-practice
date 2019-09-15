package com.tej.DailyCodingProblems;

import com.tej.LinkedList.LinkedList;

import java.util.List;
import java.util.Queue;

public class DCP16 {
    final static int N = 10;
    static List<String> queue = new java.util.LinkedList<>();

    public static void main(String[] args) {
        record("1");
        record("2");
        record("3");
        record("4");
        record("5");
        record("6");
        record("7");
        record("8");
        record("9");
        record("10");
        record("11");

        System.out.println(get_last(10));
    }

    public static void record(String order_id){

        queue.add(order_id);
        if(queue.size() > N)
            queue.remove(0);
    }

    public static String get_last(int i){
        if(N - i >= 0)
            return queue.get(N-i);
        return null;

    }
}
