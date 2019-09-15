package com.tej.DynamicProgramming;

public class LongestPalindrome {
    static int lstart = 0;
    static int lend = 0;
    static int maxInterval = Integer.MIN_VALUE;
    public static String longestPalindrome(String s){
        if(s == null || s.equals(""))
            return "";
        int l = s.length();
        boolean [][] arr = new boolean [l][l];
        boolean [][] visited = new boolean [l][l];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                longestPalindrome(s,j,i,arr,visited);
            }
        }
        return s.substring(lstart,lend+1);
    }

    public static void checklongest(int start, int end){
        if(end - start + 1 > maxInterval)
        {
            maxInterval = end - start + 1;
            lstart = start;
            lend = end;
        }
    }

    public static boolean longestPalindrome(String s, int start, int end, boolean [][] arr, boolean [][] visited){
        // checking the basic conditions
        if(start < 0 || start >= s.length() || end < 0 || end >= s.length() || end < start)
            return false;

        if(!visited [start][end]){
            visited[start][end] = true;
            arr[start][end] = (s.charAt(start) == s.charAt(end)) && (longestPalindrome(s, start + 1, end - 1, arr, visited) ||
                    start == end || start + 1 == end);
            if(arr[start][end]){
                checklongest(start,end);
            }
        }

        return arr[start][end];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bm"));
    }
}
