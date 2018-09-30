package com.tej;

public class BinarySearch {
    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6};
        System.out.println(binarySearch(arr,-2));
    }

    public static boolean binarySearch(int [] arr, int value){
        int i=0;
        int j= arr.length-1;

        while(i<=j){
            int mid = (i+j) / 2;
            if(arr[mid] == value)
                return true;
            if(arr[mid] < value)
                i = mid + 1;
            if(arr[mid] > value)
                j = mid - 1;
        }

        return false;
    }
}
