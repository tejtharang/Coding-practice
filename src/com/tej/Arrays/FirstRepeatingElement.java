package com.tej.Arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
    public static void main(String [] args){
        int [] arr = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeating(arr));
    }

    public static int firstRepeating(int [] arr){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<arr.length; i++){
            if(map.containsKey(arr[i]) && map.get(arr[i]) < minIndex){
                minIndex = map.get(arr[i]);
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }
        }
        return arr[minIndex];
    }
}
