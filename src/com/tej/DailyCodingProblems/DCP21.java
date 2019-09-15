package com.tej.DailyCodingProblems;

import java.util.*;

public class DCP21 {
    static class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static boolean conflict(Interval a, Interval b){
        return a == null || b == null || b.start < a.end;
    }

    public static Comparator<Interval> startTimeComparator = new Comparator<Interval>(){
        @Override
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    };

    public static int minConferenceRoomsRequired(List<Interval> meetings){
        Collections.sort(meetings, startTimeComparator);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end - b.end);

        for(Interval meeting : meetings){
            if(!conflict(pq.peek(), meeting))
                pq.poll();
            pq.add(meeting);
        }
        return pq.size();
    }


    public static void main(String[] args) {
        // [(30, 75), (0, 50), (60, 150)]
        List<Interval> list = new ArrayList<>(Arrays.asList(new Interval(30,75),new Interval(0,50), new Interval(60,150)));
        System.out.println(minConferenceRoomsRequired(list));
    }
}
