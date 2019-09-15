package com.tej.triplebyte.games;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MazeGame {
    public static void main(String[] args) {
        List<List<String>> maze = generateMaze();
        play(maze);
    }
    public static List<List<String>> generateMaze(){
        List<List<String>> maze = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/tej/Documents/mazegame.txt"));
            String line = br.readLine();
            while(line != null){
                List<String> innerList;
                String [] row = line.split(",");
                innerList = Arrays.asList(row);
                maze.add(innerList);
                line = br.readLine();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return maze;
    }

    public static void printMaze(List<List<String>> maze, int row, int col){
        List<List<String>> currentMaze = maze;
        currentMaze.get(row).set(col,"X");
        for(List<String> i : currentMaze){
            for(String j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void autosolver(List<List<String>> maze){
        int row=0,col=0;

    }

    public static void play(List<List<String>> maze){
        Scanner sc = new Scanner(System.in);
        int row = 0,col = 0;
        String command;
        printMaze(maze,0,0);
        while(!(row == 1 && col == 1)){
            command = sc.next();
            if(command.equals("w")){
                try{
                    if(maze.get(row-1).get(col).equals("1")){
                        System.out.println("WALL!!");
                    }
                    else {
                        row--;
                    }
                }
                catch(Exception e){
                    System.out.println("WALL!!!");
                }

            }

            else if(command.equals("a")){
                try{
                    if(maze.get(row).get(col-1).equals("1")){
                        System.out.println("WALL!!");
                    }
                    else {
                        col--;
                    }
                }
                catch(Exception e){
                    System.out.println("WALL!!!");
                }
            }
            else if(command.equals("s")){
                try{
                    if(maze.get(row+1).get(col).equals("1")){
                        System.out.println("WALL!!");
                    }
                    else {
                        row++;
                    }
                }
                catch(Exception e){
                    System.out.println("WALL!!!");
                }
            }
            else if(command.equals("d")){
                try{
                    if(maze.get(row).get(col+1).equals("1")){
                        System.out.println("WALL!!");
                    }
                    else {
                        col++;
                    }
                }
                catch(Exception e){
                    System.out.println("WALL!!!");
                }
            }
            else{
                System.out.println("Invalid command");
            }
            printMaze(maze,row,col);

        }

        if(row == 1 && col == 1){
            System.out.println("WIN!!");
        }
        else {
            System.out.println("FAIL!!");
        }
    }
}
