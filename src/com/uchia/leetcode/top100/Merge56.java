package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Merge56 {
    // facebook amazon bytedance
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int[] element = list.peekLast();

            if (start > element[1]) {
                list.add(intervals[i]);
            } else if (element[1] >= start && element[1] < end) {
                element[1] = end;
            }
        }

        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Merge56 merge56 = new Merge56();

        Utils.printArrays(merge56.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        }));

        Utils.printArrays(merge56.merge(new int[][]{
                {1, 4}, {4, 5}
        }));

        Utils.printArrays(merge56.merge(new int[][]{
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        }));
    }

}
