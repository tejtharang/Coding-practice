package com.tej.Arrays;

import java.util.*;

public class MergeIntervals {

    public static boolean conflict(Interval i, Interval j){
        if(i == null || j == null)
            return true;
        return j.start < i.end;
    }


    public static class Interval implements Comparable<Interval>{
        int start;
        int end;
        Interval(){start = 0; end = 0;}
        Interval(int s, int e){
            this.start = s;
            this.end = e;
        }
        @Override
        public int compareTo(Interval i){
            return this.start - i.start;
        }
    }

    public static Comparator<Interval> comparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.end - o2.end;
        }
    };

    // 1-3, 2-6, 1-2, 3-5
    // 1-3, 1-2, 2-6, 3-5
    public static int minimumConferenceRoomsRequired(List<Interval> intervals) {
        Collections.sort(intervals);
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.size(), comparator);
        for(Interval i : intervals){

            if(!conflict(pq.peek(), i))
                pq.poll();

            pq.add(i);
        }
        return pq.size();
    }

    public static void main(String [] args){
        List<Interval> list = new ArrayList<Interval>(Arrays.asList(
                new Interval(1,3),
                new Interval(2,6),
                new Interval(1,2),
                new Interval(3,5)));
        System.out.println(minimumConferenceRoomsRequired(list));
    }
}
