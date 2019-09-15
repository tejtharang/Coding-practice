package com.tej.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroMatrix {
    public static void main(String[] args) {
        int [][] arr = {{1,1,0},{1,1,1}};
        makezero(arr);
        for(int i =0 ; i<arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void makezero(int [][] a){
        int M = a.length;
        int N = a[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(a[i][j] == 0){
                    Integer [] listArray = {i,j};
                    list.add(Arrays.asList(listArray));
                }
            }
        }

        for(List<Integer> l : list){
            int m = l.get(0);
            int n = l.get(1);
            for(int i = 0;i<N ;i++){
                a[m][i] = 0;
            }
            for(int i = 0;i<M;i++){
                a[i][n] = 0;
            }
        }
    }
}
