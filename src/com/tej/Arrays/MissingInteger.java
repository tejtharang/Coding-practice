package com.tej.Arrays;

public class MissingInteger {
    public static void main(String [] args){
        int [] arr = {4,2,5,1};
        System.out.println(numberMissed(arr));
    }

    public static Integer numberMissed(int [] arr){
        Integer sum = 0;
        for(int i : arr){
            sum += i;
        }
        int len = arr.length + 1;
        Integer totalsum = len* (len + 1)/2;
        return totalsum - sum;
    }
}
