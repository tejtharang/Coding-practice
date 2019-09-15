package com.tej.Arrays;

public class SmallestPositiveIntegerThatCannotbeRepresentedAsSum {
    public static void main(String[] args) {
        int [] arr = {1,1,3,4,5};
        System.out.println(smallest(arr));
    }

    public static int smallest(int [] arr){
        int res = 1;
        for(int i=0;i<arr.length && arr[i] <= res; i++){
            res = res + arr[i];
        }

        return res;
    }
}
