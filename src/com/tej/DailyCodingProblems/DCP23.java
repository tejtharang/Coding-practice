package com.tej.DailyCodingProblems;

import java.util.Arrays;

public class DCP23 {
    public static void main(String[] args) {
        boolean [][] maze = {{false,false,false,false},{true, true, false,true}, {false,false,false,false},{false,false,false,false}};
        System.out.println(findMinimumStepsFromStartToFinish(maze, 3,0,0,0));
    }

    public static Integer findMinimumStepsFromStartToFinish(boolean [][] maze, int starti, int startj, int endi,int endj){
        int [][] distances = new int[maze.length][maze[0].length];
        for( int [] arr : distances){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        boolean [][] visited = new boolean [maze.length][maze[0].length];
        distances[endi][endj] = 0;
        dfs(maze,visited, distances,starti,startj,endi,endj);
        return distances[starti][startj];
    }

    public static void dfs(boolean [][] maze, boolean [][] visited,  int [][] distances, int starti, int startj, int i,int j){
        if(i< 0 || j < 0 || i >= maze.length || j >= maze[0].length || maze[i][j] || visited[i][j])
            return;

        visited[i][j] = true;

        if(i == starti && j == startj)
            return;

        if(i-1 >=0)             distances[i-1][j] = Math.min(distances[i-1][j], distances[i][j] + 1);
        if(i+1 < maze.length)   distances[i+1][j] = Math.min(distances[i+1][j], distances[i][j] + 1);
        if(j-1 >= 0)            distances[i][j-1] = Math.min(distances[i][j-1], distances[i][j] + 1);
        if(j+1 < maze[0].length)distances[i][j+1] = Math.min(distances[i][j+1], distances[i][j] + 1);

        dfs(maze, visited, distances, starti,startj, i-1,j);
        dfs(maze, visited, distances, starti,startj, i+1,j);
        dfs(maze, visited, distances, starti,startj, i,j-1);
        dfs(maze, visited, distances, starti,startj, i,j +1);

    }
}
