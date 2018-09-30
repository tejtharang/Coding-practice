package com.tej;

import java.util.*;

public class PermutationsWithinString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String small = s.next();
        String big = s.next();

        List<String> list = returnPermutations(small,big);

        for(String k : list) {
            System.out.println(k);
        }
    }

    public static List<String> returnPermutations(String small, String big){

        List<String> list = new ArrayList<String>();
        if(small.length() > big.length())
            return list;

        for(int i=0 ; i<big.length() - small.length() +1;i++){
            int flag = 0;
            Map<Character, Integer> newMap = returnMap(small);
            String test = new String();
            if(i + small.length() >= big.length())
                test = big.substring(i);
            else
                test = big.substring(i,i+small.length());
            for(Character c : test.toCharArray()){
                if(!newMap.containsKey(c)){
                    flag = 1;
                    break;
                }
                else{
                    if(newMap.get(c) <= 0){
                        flag = 1; break;
                    }
                    else{
                        newMap.put(c,newMap.get(c) -1);
                    }
                }
            }
            if(flag != 1 )
                list.add(test);
        }
        return list;
    }

    public static Map<Character,Integer> returnMap(String small){
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for(Character c: small.toCharArray()) {
            if (map.containsKey(c))
                map.put(c,map.get(c) + 1);
            else
                map.put(c,1);
        }
        return map;
    }
}
