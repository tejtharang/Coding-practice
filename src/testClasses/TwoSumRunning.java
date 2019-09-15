package testClasses;

import com.tej.ComparatorAndComparable.Employee;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoSumRunning {


        /** Initialize your data structure here. */
        public static Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> x-y);

        public static void main(String [] args) {
            pq.add(3);
            pq.add(2);
            pq.add(1);
            pq.add(4);
            while(!pq.isEmpty())
                System.out.println(pq.poll());

        }

        /** Add the number to an internal data structure.. */
        public static void add(int number) {
            pq.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public static boolean find(int value) {
            Object [] arr = pq.toArray();
            int start = 0;
            int end = pq.size()-1;
            while(start<end){
                int result = (int) arr[start] + (int) arr[end];
                if(result == value) return true;
                if(result < value) ++start;
                else --end;
            }
            return false;
        }


}
