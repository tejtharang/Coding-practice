package com.tej.Arrays;

import java.util.ArrayList;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int [] arr1 = {1,3,5,7,9};
        int [] arr2 = {2,4,5,7,79};
        ArrayList<Integer> a = intersection(arr1,arr2);
        System.out.println(a);
    }

    public static ArrayList<Integer> intersection(int [] arr1, int [] arr2){
        ArrayList<Integer> common = new ArrayList<Integer>();
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1 < arr1.length && pointer2 < arr2.length){
            if(arr1[pointer1] == arr2[pointer2]){
                common.add(arr1[pointer1]);
                pointer1++;
                pointer2++;
            }

            else if(arr1[pointer1] < arr2[pointer2]){
                pointer1++;
            }
            else if(arr1[pointer1] > arr2[pointer2]){
                pointer2++;
            }

        }
        return common;
    }
}
