package com.tej.Arrays;

import java.util.ArrayList;

public class IntersectionOfThreeArrays {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int [] arr2 = {2,4,6,8,10,12,14,16,18};
        int [] arr3 = {2,3,5,6,8,9,11,12};

        System.out.println(intersection(arr1,arr2, arr3).toString());

    }

    public static ArrayList<Integer> intersection(int [] arr1, int [] arr2, int [] arr3){
        ArrayList<Integer> a = new ArrayList<Integer>();
        int pointer1 = 0, pointer2 = 0, pointer3 = 0;
        while(pointer1 < arr1.length && pointer2 < arr2.length && pointer3 < arr3.length){
            if(arr1[pointer1] < arr3[pointer3] || arr2[pointer2] < arr3[pointer3]){
                if(arr1[pointer1] < arr2[pointer2])
                    pointer1++;
                else if(arr1[pointer1] > arr2[pointer2])
                    pointer2++;
                else{
                    pointer1++;pointer2++;
                }

            }
            else if(arr1[pointer1] < arr2[pointer2] || arr3[pointer3] < arr2[pointer2]){
                if(arr1[pointer1] < arr3[pointer3])
                    pointer1++;
                else if(arr1[pointer1] > arr3[pointer3])
                    pointer3++;
                else{
                    pointer3++;pointer1++;
                }

            }

            else if(arr1[pointer1] > arr2[pointer2] || arr3[pointer3] < arr1[pointer1]){
                if(arr2[pointer2] < arr3[pointer3])
                    pointer2++;
                else if(arr2[pointer2] > arr3[pointer3])
                    pointer3++;
                else{
                    pointer3++;pointer2++;
                }

            }

            else if (arr1[pointer1] == arr2[pointer2] && arr2[pointer2] == arr3[pointer3]){
                a.add(arr1[pointer1]);
                pointer1++;pointer2++;pointer3++;
            }
        }

        return a;
    }
}
