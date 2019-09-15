package com.tej;

import java.util.ArrayList;
import java.util.List;

public class MaximumDifferenceOddEven {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(-2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(1);
        System.out.println(difference(list));
    }
    public static int difference(List<Integer> arr){
        int p1 = 0;
        int p2 = arr.size() -1;
        int max = Integer.MAX_VALUE;
        while(p1 < p2){
            while(arr.get(p1) % 2 == 0){
                p1++;
            }
            while(arr.get(p2) % 2 != 0){
                p2--;
            }
            if(p1 < p2) {
                int diff = Math.abs(arr.get(p1) - arr.get(p2));
                if(diff > max){
                    max = diff;
                }
            }

        }
        return max;
    }
}
