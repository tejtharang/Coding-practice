package com.tej.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void generateBitStrings(int level, int n, List<Integer> bitString, List<List<Integer>> setOfBitStrings){
        if(level == n){
            setOfBitStrings.add(new ArrayList<>(bitString));
            return;
        }

        bitString.set(level,0);
        generateBitStrings(level + 1, n, bitString, setOfBitStrings);

        bitString.set(level,1);
        generateBitStrings(level + 1, n, bitString, setOfBitStrings);
    }

    public static List<List<Integer>> generateSubsets(int [] nums){
        List<Integer> bitString = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            bitString.add(0);
        }
        List<List<Integer>> setOfBitStrings = new ArrayList<>();
        List<List<Integer>> retSet = new ArrayList<>();
        generateBitStrings(0, nums.length, bitString, setOfBitStrings);
        System.out.println(setOfBitStrings);
        for(List<Integer> b : setOfBitStrings){
            List<Integer> subset = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(b.get(i)==1){
                    subset.add(nums[i]);
                }
            }
            retSet.add(subset);
        }
        return retSet;
    }
    public static void main(String [] args) {
        int[] arr = {1, 2, 3};
        System.out.println(generateSubsets(arr));
    }
}
