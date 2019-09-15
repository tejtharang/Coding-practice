package com.tej.Arrays;

import java.util.Arrays;

public class Rotate90 {
    public static void main(String[] args) {
        int [][] arr = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
        arr = rotate90(arr);
        for(int i =0 ; i<4; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int [][] rotate90(int [][] a){
        int n = a.length;
        int i=0, J = n-1;
        while(i < J){
            for(int j=i;j<J;j++){
                int temp = a[j][j];
                a[j][j] = a[j][J];
                a[j][J] = a[J][J-j];
                a[J][J-j] = a[J-j][j];
                a[J-j][j] = temp;
            }
            J--;i++;
        }
        return a;
    }
}
