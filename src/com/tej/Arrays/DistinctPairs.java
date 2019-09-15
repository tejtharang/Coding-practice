package com.tej.Arrays;

import java.util.Arrays;

public class DistinctPairs {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 1, 9};
        System.out.println(numberOfDistinctPairs(arr,10));
    }

    public static int numberOfDistinctPairs(int [] arr, int target)
    {
        int num = 0;
        if(arr == null || arr.length == 0)
            return 0;
        Arrays.sort(arr);
        for(int i=0, j= arr.length -1; i<j;){
            if(arr[i] + arr[j] == target) {
                num++;
                int left = arr[i];
                int right = arr[j];
                while(arr[i] == left){
                    i++;
                }
                while(arr[j] == right){
                    j--;
                }
            }
            else if(arr[i] + arr[j] < target){
                int left = arr[i];
                while(arr[i] == left){
                    i++;
                }
            }
            else {
                int right = arr[j];
                while (arr[j] == right) {
                    j--;
                }
            }

        }
        return num;
    }
}
