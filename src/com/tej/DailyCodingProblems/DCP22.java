package com.tej.DailyCodingProblems;

import java.util.*;

public class DCP22 {

    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<>(Arrays.asList("I","a","am","ace"));
        System.out.println(wordBreak2("Iamace",wordDict));
    }

    public static boolean wordBreak1(String s, Set<String> wordDict){
        boolean [] t = new boolean[s.length() + 1];
        t[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(!t[j])
                    continue;
                if(wordDict.contains(s.substring(j,i)))
                    t[i] = true;
            }
        }
        return t[s.length()];
    }

    public static List<String> wordBreak2(String s, Set<String> wordDict){
        boolean [] t = new boolean[s.length() + 1];
        t[0] = true;

        List<String> [] combinations = new List[s.length() + 1];
        combinations[0] = new ArrayList<>();

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(!t[j]) continue;
                if(wordDict.contains(s.substring(j,i))){
                    t[i] = true;
                    combinations[i] = new ArrayList<>(combinations[j]);
                    combinations[i].add(s.substring(j,i));
                }
            }
        }

        return combinations[6];
    }

}
