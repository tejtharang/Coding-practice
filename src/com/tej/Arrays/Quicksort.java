package com.tej.Arrays;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {

        int [] arr = {5,4,3,2,1};
        if(arr.length>1){
            sort(arr,0,arr.length-1);
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int [] arr, int start, int end){
        if(start<end) {
            int pivot = end;
            int pindex = start;
            for (int i = start; i < end; i++) {
                if (arr[i] <= arr[pivot]) {
                    swap(arr, i, pindex);
                    pindex++;
                }
            }
            swap(arr, pindex, pivot);
            return pindex;
        }
        return start;
    }

    public static void sort(int [] arr, int start, int end){
        int p = partition(arr, start, end);
        sort(arr,start,p-1);
        sort(arr,p+1,end);
    }
}
