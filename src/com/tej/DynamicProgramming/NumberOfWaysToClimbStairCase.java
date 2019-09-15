package com.tej.DynamicProgramming;

public class NumberOfWaysToClimbStairCase {
    public static void main(String[] args) {
        System.out.println(returnNumberOfWays(5, new int[] {1,3,5}));
    }


    public static int returnNumberOfWays(int n){
        if(n <= 2)
            return n;
        int temp ,a = 1, b = 2;
        for(int i = 2;i<n;i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static int returnNumberOfWays(int numberOfSteps, int [] stepSizes){
        int [] numberOfWays = new int[numberOfSteps];
        for(int stepSize : stepSizes){
             numberOfWays[stepSize -1]++;
        }
        for(int i=1;i<numberOfSteps;i++){
             for( int stepSize : stepSizes){
                 if(i- stepSize >=0)
                     numberOfWays[i] += numberOfWays[i+1 - stepSize];
             }
        }
        return numberOfWays[numberOfSteps-1];
    }
}
