package com.tej.Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// The assumption is that there are multiple duplicates in an array and we are trying
// to return those elements alone
public class MultipleDuplicates {
    public static void main(String[] args) {
        int [] arr = {-1,-2,3,4,5,6,5,2,7,9,7,4,6,8,4,2,56,7};
        ArrayList<Integer> a = multipleDups(arr);
        System.out.println(a);
    }

    public static ArrayList<Integer> multipleDups(int [] arr){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();

        for(int i : arr){
            if(!set.contains(i))
                set.add(i);
            else{
                if(!arrayList.contains(i))
                    arrayList.add(i);
            }

        }
        return arrayList;
    }
}
