package com.tej.Arrays;

public class Kthsmallestnumber {
    public static void main(String[] args) {
        int [] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,4));
    }

    public static  int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length || (nums.length == 1 && k>1))
            return Integer.MIN_VALUE;
        if(nums.length == 1 && k == 1)
            return nums[0];

        return kthSmallest(nums,0,nums.length-1, k-1);
    }
    public static void swap(int [] arr, int l, int r){
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
    public static int partition(int [] arr,int l, int r){
        if(l <= r) {
            int pindex = l;
            int pivot = r;

            for (int i = l; i < r; i++) {
                if (arr[i] <= arr[pivot]) {
                    swap(arr, i, pindex);
                    pindex++;

                }
            }

            swap(arr, pindex, pivot);
            return pindex;
        }
        return arr[l];
    }

    public static int kthSmallest(int [] arr, int l, int r, int k){
        int pindex = partition(arr,l,r);
        int ret = 0;

        // checking if kth value is the index
        if(l<=r){
            if(pindex == k)
                ret = arr[pindex];
            else if(pindex < k){
                ret = kthSmallest(arr, pindex+1, r,k);
            }
            else{
                ret = kthSmallest(arr, l, pindex-1,k);
            }
        }
        return ret;
    }
}
