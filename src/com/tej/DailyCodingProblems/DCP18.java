package com.tej.DailyCodingProblems;

import java.util.*;

public class DCP18 {

    public static void main(String[] args) {
        int [] arr = {10,5,2,7,8,7};
        System.out.println(function(arr,3));
    }

    /*
        when n = 5 and k = 4, we have 2
        when n = 5 and k = 3, we have 3
        when n = 5 and k = 2, we have 4
     */

    // Deque is the key here

    public static List<Integer> function(int [] arr, int k){
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        list.add(arr[deque.peek()]);

        for(int i=k;i<arr.length;i++){
            while(!deque.isEmpty() && deque.peek() <= i-k ){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(i);
            list.add(arr[deque.peek()]);
        }

        return list;
    }
}
