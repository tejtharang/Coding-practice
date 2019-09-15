package com.tej.Arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int [] arr = {0,0,0,0};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<Set<Integer>> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++)
            {
                if(i!=j){
                    List<Integer> addonlist = new ArrayList<Integer>(Arrays.asList(i,j));
                    map.put(nums[i]+nums[j], addonlist);
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            int result = 0-nums[i];
            if(map.containsKey(result) && !map.get(result).contains(i)){
                List<Integer> addon = new ArrayList<Integer>(map.get(result));
                addon.add(i);
                Set<Integer> addonset = new HashSet<>();
                for(Integer k : addon){
                    addonset.add(k);
                }
                if(!set.contains(addonset)){
                    set.add(addonset);
                }
            }
        }

        List<List<Integer>> retList = new ArrayList<>();
        for(Set<Integer> s: set){
            List<Integer> subList = new ArrayList<>();
            for(Integer i : s){
                subList.add(nums[i]);
            }
            if(!retList.contains(subList))
                retList.add(subList);
        }

        return retList;
    }
}
