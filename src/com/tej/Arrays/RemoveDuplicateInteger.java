package com.tej.Arrays;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateInteger {
    public static void main(String [] args){
        int [] arr = {0,1,2,2,4};
        System.out.println(duplicate(arr));
    }

    public static int duplicate(int [] arr){
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i : arr){
            if(!map.containsKey(i)){
                map.put(i,1);
            }
            else{
                map.put(i,map.get(i) + 1);
                return i;
            }
        }
        return -1;
    }
}
