package com.uchia.leetcode.dynamics.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumTotal120 {
    // amazon google apple
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }

        for (int i = m - 2; i >= 0; i--) {
            List<Integer> layer = triangle.get(i);
            for (int j = 0; j < layer.size(); j++) {
                dp[j] = layer.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        MinimumTotal120 total120 = new MinimumTotal120();
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> subList = Arrays.asList(-10);
        lists.add(subList);
        System.out.println("min: " + total120.minimumTotal(lists));

        lists = new LinkedList<>();
        lists.add(Arrays.asList(    2));
        lists.add(Arrays.asList(   3,4));
        lists.add(Arrays.asList(  6,5,7));
        lists.add(Arrays.asList( 4,1,8,3));
        System.out.println("min: " + total120.minimumTotal(lists));
    }
}
