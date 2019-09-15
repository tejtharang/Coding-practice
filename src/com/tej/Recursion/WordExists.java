package com.tej.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordExists {

    public static void main(String[] args) {
        //char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        /*char [][] board = {
                {'a','a','a'},
                {'a','b','b'},
                {'a','b','b'},
                {'b','b','b'},
                {'b','b','b'},
                {'a','a','a'},
                {'b','b','b'},
                {'a','b','b'},
                {'a','a','b'},
                {'a','b','a'}};*/
        //String word = "aabaaaabbb";
        char [][] board = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
        String word = "aaaaaaaaaaaaa";
        System.out.println(exist(board,word));
    }
    public static class Index {
        int i;
        int j;
        public Index(int i,int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public boolean equals(Object o){
            if(! (o instanceof Index))
                return false;
            Index I = (Index)o;
            return (I.i == this.i && I.j == this.j);
        }
    }

    public static List<Index> getNeighbours(char [][] board, int i, int j){
        int row = board.length;
        int col = board[0].length;
        int pi = (i+1) % row;
        int pj = (j+1) % col;
        int ni = i-1;
        if(ni <0)
            ni = row + ni;
        int nj = j-1;
        if(nj < 0)
            nj = col + nj;

        List<Index> list = new ArrayList<Index>(Arrays.asList(new Index(i,nj),
                new Index(i,pj),
                new Index(pi,j),
                new Index(ni,j)                                                               ));
        List<Index> retList = new ArrayList<>();
        for(Index I:list){
            if(!retList.contains(I) && !I.equals(new Index(i,j)))
                retList.add(I);
        }

        return retList;
    }

    public static boolean exists(char[][] board, String word, boolean [][] visited,
                          int curri, int currj){

        if(word.length() == 0)
            return true;
        int row = board.length;
        int col = board[0].length;



        // generating neighbours, checking if they are valid
        List<Index> indices = getNeighbours(board, curri, currj);
        for(Index I : indices){

            if(!visited[I.i][I.j] && word.charAt(0) == board[I.i][I.j]){
                visited[I.i][I.j] = true;
                if(word.length() == 1) {

                    return true;

                }
                else if(exists(board, word.substring(1), visited, I.i,I.j))
                    return true;
            }
            visited[I.i][I.j] = false;
        }
        return false;

    }
    public static boolean exist(char[][] board, String word) {
        if(word.length() == 0)
            return false;
        int row = board.length, col = 0;
        if(row >0)
            col = board[0].length;


        for(int i=0;i<row;i++){
            for(int j=0; j<col;j++){

                if(board[i][j] == word.charAt(0)){
                    if(word.length() == 1)
                        return true;
                    int k = 1;
                    boolean [][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    if(exists(board,
                            word.substring(k),
                            visited,
                            i,j)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }
}
