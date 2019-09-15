package com.tej.triplebyte.games;

import java.util.Scanner;

public class Tictactoe {

    public static void main(String[] args) {
        int [][] board = new int[3][3];
        boolean gameover = false;
        printBoard(board);
        System.out.println("Begin game!");
        while(!gameover){
            play(1, board);printBoard(board);
            gameover = checkWinner(1,board);
            if(gameover){
                System.out.println("Player 1 wins");
                break;
            }

            play(2,board);printBoard(board);
            gameover = checkWinner(2,board);
            if(gameover){
                System.out.println("Player 2 wins");
                break;
            }

        }
    }

    public static boolean checkWinner(int player, int [][] board){
        for(int i=0;i<3;i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }

            if(board[0][i] == player && board[1][i] == player && board[2][i] == player){
                return true;
            }
        }

        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[2][0] == player && board[1][1] == player && board[0][2] == player){
            return true;
        }

        return false;
    }

    public static void play(int player, int [][] board){
        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + player);

        boolean validMove = false;

        while(!validMove){
            System.out.println("row : ");
            int row = Integer.parseInt(sc.next());
            System.out.println("col : ");
            int col = Integer.parseInt(sc.next());
            if(row < 3 && col < 3 && board[row][col] == 0) {
                validMove = true;
                board[row][col] = player;
            }
            else{
                System.out.println("Invalid move, please play again!");
            }
        }
    }

    public static void printBoard(int [][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
