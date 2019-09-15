package com.tej.Arrays;

import java.util.Arrays;

public class Toptwonumbers {
    public static void main(String[] args) {
       int [] arr = {1,9,2,8,3,7,4,6,4};
        System.out.println(Arrays.toString(toptwo(arr)));
    }

    public static int [] toptwo(int [] arr){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i : arr){
            if(i > max1){
                max2 = max1;
                max1 = i;
            }
            else if(i > max2){
                max2 = i;
            }

        }
        int [] ret = {max1, max2};
        return ret;
    }
}
