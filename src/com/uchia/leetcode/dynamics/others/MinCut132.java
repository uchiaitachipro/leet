package com.uchia.leetcode.dynamics.others;

import java.util.Arrays;

public class MinCut132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] cache = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                cache[i][j] = s.charAt(i) == s.charAt(j) && cache[i + 1][j - 1];
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (cache[0][i]) {
                dp[i] = 0;
            } else {

                for (int j = 0; j < i; j++) {
                    if (cache[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }

            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        MinCut132 cut132 = new MinCut132();

        // 1
        String s = "aab";
        System.out.println("count: " + cut132.minCut(s));

        // 0
        s = "a";
        System.out.println("count: " + cut132.minCut(s));

        // 1
        s = "ab";
        System.out.println("count: " + cut132.minCut(s));
    }

}
