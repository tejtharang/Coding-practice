package com.tej.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberNotRepeatedTwice {
    public static void main(String [] args){
       int [] arr = {1,3,5,2,5,3,1};
       ArrayList<Integer> arrayList = unrepeated(arr);
       System.out.println(arrayList);
    }

    public static ArrayList<Integer> unrepeated(int [] arr){
        Set<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i : arr){
            if(!set.contains(i))
                set.add(i);
            else
                set.remove(i);
        }
        for(int i : set){
            arrayList.add(i);
        }
        return arrayList;
    }
}
