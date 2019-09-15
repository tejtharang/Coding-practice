package com.tej.Arrays;

import java.util.Arrays;
import java.util.List;

public class LargestAndSmallest {
    public static void main(String[] args) {
        int [] arr = {9,3,6,1,6,4,-4,6,5,2,6,3,4,6,5};
        int [] minmax = largestAndSmallest(arr);
        System.out.println(Arrays.toString(minmax));
    }

    public static int [] largestAndSmallest(int [] arr){
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        for(int i: arr){
            if(i>max)
                max = i;
            if(i<min)
                min = i;
        }
        int [] minmax = {min,max};
        return minmax;
    }
}
