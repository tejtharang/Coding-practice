package com.tej.Arrays;

public class SearchInSortedRotatedArray {
    public static int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int l = nums.length;
        int end = pivotSearch(nums);
        int start = (end+1) % l;
        int prevstart = Integer.MIN_VALUE;
        int prevend = Integer.MIN_VALUE;
        while(start!=end){
            if(prevstart == start && prevend == end){
                return -1;
            }
            prevstart = start;
            prevend = end;
            int mid;
            if(start > end) {
                mid = Math.abs(l - start + end);
            }
            else{
                mid = (start + end) / 2;
            }

            if(nums[mid] < target){
                start = (start +1)%l;
            }
            else if(nums[mid] > target){
                if(end-1 < 0)
                    end = l+end-1;
                else
                    end = (end-1) % l;
            }
            else{
                return mid;
            }
        }
        if(nums[start] == target)
            return start;
        return -1;
    }

    public static int pivotSearch(int [] nums){

        int l = 0;
        int r = nums.length -1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] < nums[l])
                r = mid -1;
            else
                l = mid +1;
        }
        return l;
    }

    public static void main(String[] args) {
        int [] arr = {3,1,1,1};
        System.out.println(search(arr,0));
    }
}
