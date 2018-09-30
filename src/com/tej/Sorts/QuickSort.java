package com.tej.Sorts;

public class QuickSort {
    public static void swap(int [] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int [] arr,int left, int right){
        int pindex = left;
        int pivot = right;
        for(int i=left;i<right;i++){
            if(arr[i] <= arr[pivot]){
               swap(arr,i,pindex);
               pindex++;
            }
        }
        swap(arr,pindex,pivot);
        return pindex;
    }

    public static void quickSort(int [] arr, int left, int right){
        if(left < right) {
            int pindex = partition(arr,left,right);
            quickSort(arr, left, pindex - 1);
            quickSort(arr, pindex + 1, right);
        }
    }

    public static void main(String [] args){
        int [] arr = {9,2,8,1,7,3,5,4};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

}
