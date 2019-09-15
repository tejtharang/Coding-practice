package com.tej.Arrays;

public class SecondSmalles {
    public static void main(String[] args) {
        int [] arr = {4,2,7,3,9,1};
        System.out.println(secondSmallest(arr));
    }

    public static int secondSmallest(int [] arr){
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i : arr){
            if(i < min1){
                min2 = min1;
                min1 = i;
            }
            if(i<min2 && i != min1){
                min2 = i;
            }
        }

        return min2;
    }
}
