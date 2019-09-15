package com.tej.DailyCodingProblems;

public class DCP19 {

    public static void main(String[] args) {
        int [][] arr = {{1,2,3},{1,2,3},{1,2,3}};
        System.out.println(minCost(arr));
    }

    public static int [] twoSmallestIndices(int [][] costs, int row){
        int min1 = 0;
        int min2 = -1;

        // calculating the last house's min and second min cost
        for(int j = 1; j<costs[0].length ; j++){
            if(costs[row][j] <= costs[row][min1]){
                min2 = min1;
                min1 = j;
            }

            else if(min2 == -1 || costs[row][j] <= costs[row][min2]){
                min2 = j;
            }
        }

        return new int [] {min1, min2};

    }

    public static int minCost(int [][] costs){
        int houses = costs.length;
        int colors = costs[0].length;
        // need to address no rows or columns

        int [] min1andmin2 = twoSmallestIndices(costs,houses-1);
        int min1 = min1andmin2[0], min2 = min1andmin2[1];

        //calculating the each row's max and min and propogating it to the next
        for(int i=houses-2; i>=0;i--){
            for(int j=0;j<colors;j++){
                if(j != min1)
                    costs[i][j] += costs[i+1][min1];
                else
                    costs[i][j] += costs[i+1][min2];
            }
            min1andmin2 = twoSmallestIndices(costs,houses-1);
            min1 = min1andmin2[0]; min2 = min1andmin2[1];

        }

        return costs[0][min1];
    }
}
