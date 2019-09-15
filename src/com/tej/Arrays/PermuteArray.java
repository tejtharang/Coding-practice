package com.tej.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermuteArray {
    public static void main(String[] args) {
        int [] rem = {1,2,3};
        int [] prefix ={};
        permute(Arrays.asList(0,1,2),0);
    }

    public static void permute(List<Integer> list, int k){
        for(int i = k;i<list.size();i++){
            Collections.swap(list,i,k);
            permute(list,k+1);
            Collections.swap(list,i,k);
        }
        if(k == list.size() -1){
            System.out.println(list.toString());
        }
    }
}
