package com.tej.Recursion;

import java.util.*;

public class Subsets {
    public static void main(String [] args){
        int [] nums = {1,2,3,4};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums, int setSize) {
        List<List<Integer>> retList = new ArrayList<>();
        if(setSize == 0)
            return retList;
        if(setSize == 1){
            for(int i :nums){
                retList.add(new ArrayList<Integer>(Arrays.asList(i)));
            }
            retList.add(new ArrayList<Integer>());
            return retList;
        }
        List<List<Integer>> set = subsets(nums,setSize-1);

        for(int i : nums){
            for(List<Integer> innerset : set){
                if(innerset.size() == setSize -1 && !innerset.contains(i))
                {
                    List<Integer> kk = new ArrayList<Integer>(innerset);
                    kk.add(i);
                    Collections.sort(kk);
                    if(!retList.contains(kk))
                        retList.add(kk);
                }
            }

        }
        for(List<Integer> s : set){
            retList.add(s);
        }
        return retList;

    }

    public static List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length);
    }
}
