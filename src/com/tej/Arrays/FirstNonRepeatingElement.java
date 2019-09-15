package com.tej.Arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int [] arr = {5,3,10,4,3,5,10,3,6};
        System.out.println(nonRepeatingElement(arr));
    }

    public static int nonRepeatingElement(int [] arr){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : arr){
            if(!map.containsKey(i)){
                map.put(i,1);
            }
            else{
                map.put(i,map.get(i) + 1);
            }
        }

        for(int i :arr){
            if(map.get(i) == 1)
                return i;
        }

        return Integer.MIN_VALUE;
    }
}
