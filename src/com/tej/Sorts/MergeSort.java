package com.tej.Sorts;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int [] arr, int [] left, int [] right){
        int i =0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }
            else
                arr[k++] = right[j++];
        }
        while(i<left.length){
            arr[k++] = left[i++];
        }
        while(j<right.length){
            arr[k++] = right[j++];
        }
    }

    public static void mergeSort(int [] arr){
        if(arr.length < 2){
            return;
        }
        int m = arr.length/2;
        int [] left = new int[m];
        int [] right = new int[arr.length - m];
        for(int i=0;i<m;i++){
            left[i] = arr[i];
        }

        for(int j=m;j<arr.length;j++){
            right[j-m] = arr[j];
        }


        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);
    }

    public static void main(String[] args) {
        int [] array = {9,2,8,3,6,4,1,5};
        mergeSort(array);
        for(int i=0;i<array.length;i++)
            System.out.print(array[i] + " ");
    }
}
