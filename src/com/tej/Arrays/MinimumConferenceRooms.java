package com.tej.Arrays;

import java.util.*;

public class MinimumConferenceRooms {
    public static void main(String [] args){
        Interval [] arr = {new Interval(0,30),
        new Interval(5,10),
        new Interval(15,20)};

        System.out.println(minMeetingRooms(arr));
    }
    public static class Interval{
        int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public static boolean compatible(Interval a, Interval b){
        return a.end > b.start;
    }
    public static int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, comparator);
        PriorityQueue<Interval> pq = new PriorityQueue<>(leastEndComparator);
        for(Interval i : intervals){
            if(pq.isEmpty())
                pq.add(i);
            else{
                if(compatible(pq.peek(), i))
                {
                    pq.poll();
                }
                pq.add(i);

            }
        }

        return pq.size();
    }

    public static Comparator<Interval> leastEndComparator = new Comparator<Interval>(){
        @Override
        public int compare(Interval a, Interval b) { return a.end - b.end;}
    };
    public static Comparator<Interval> comparator = new Comparator<Interval>(){
        @Override
        public int compare(Interval i1, Interval i2){
            return i1.start - i2.start;
        }
    };
}
