package com.uchia.leetcode.dynamics.otherdimension;

import java.util.Arrays;

public class SplitArray410 {
    // google amazon meituan
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sums = new int[n + 1];

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= n; i++) {
            sums[i] += sums[i - 1] + nums[i - 1];
            dp[i][1] = sums[i];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.min(m, i); j++) {
                for (int k = j - 1; k <= n; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sums[i] - sums[k]));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        SplitArray410 splitArray410 = new SplitArray410();
        System.out.println("group min value: " + splitArray410.splitArray(new int[]{
                7, 2, 5, 10, 8
        }, 2));

        System.out.println("group min value: " + splitArray410.splitArray(new int[]{
                1,2,3,4,5
        }, 2));

        System.out.println("group min value: " + splitArray410.splitArray(new int[]{
                1,4,4
        }, 3));
    }
}
