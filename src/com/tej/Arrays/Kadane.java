import java.util.*;
// So the idea here is to try to compare the maximum subarray ending at every index

// For example,
// [1,-3,2,1,-1]
// We try to compare every sub array ending at 1, then -3, then 2, then 1 and so on
public class Kadane{
    public static void main(String [] args){
        int [] arr = {-9,-8,-7,-6,-5,-4,-3,-2,-1};
        kadane(arr);
    }

    public static void kadane(int [] arr){
        int max = Integer.MIN_VALUE, size = arr.length;
        int sum = 0;
        int start = 0,end = 0,fstart = 0, fend = 0;
        int i = 0;
        while(i < size){
            sum = sum + arr[i];
            if(max < sum){
                max = sum;
                end = i;
                fstart = start;
                fend = end;
            }
            if(sum < 0){
                sum = 0;
                start = i + 1;
                end = i + 1;
            }
            i++;
        }
        System.out.println("start : " + fstart + " end : " + fend + ". Max sum : " + max );
    }
}