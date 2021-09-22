package com.uchia.leetcode.top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms253 {
    // amazon microsoft facebook
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (ints, t1) -> ints[0] - t1[0]);

        PriorityQueue<int[]> room = new PriorityQueue<>((ints, t1) -> ints[1] - t1[1]);

        for (int i = 0; i < intervals.length; i++){
           if (!room.isEmpty() && room.peek()[1] <= intervals[i][0]){
               room.poll();
           }
           room.add(intervals[i]);
        }

        return room.size();
    }

    public static void main(String[] args) {
        MinMeetingRooms253 rooms253 = new MinMeetingRooms253();

        System.out.println("result: " +rooms253.minMeetingRooms(new int[][]{
                {0,30},{5,10},{15,20}
        }));

        System.out.println("result: " +rooms253.minMeetingRooms(new int[][]{
                {7,10},{2,4}
        }));
    }
}
