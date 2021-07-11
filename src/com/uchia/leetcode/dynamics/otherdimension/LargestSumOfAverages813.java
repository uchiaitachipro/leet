package com.uchia.leetcode.dynamics.otherdimension;

import java.util.Arrays;

public class LargestSumOfAverages813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = ((double) sum[i]) / i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int m = j; m <= i; m++) {
                    dp[i][j] = Math.max(dp[i][j], dp[m - 1][j - 1] + (sum[i] - sum[m - 1]) / (i - m + 1.0));
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        LargestSumOfAverages813 averages813 = new LargestSumOfAverages813();
        int[] A = {9,1,2,3,9};
        int k = 3;
        // 20
        System.out.println("max value: " + averages813.largestSumOfAverages(A,k));

        A = new int[]{1,2,3,4,5,6,7};
        k =4;
        // 20.5
        System.out.println("max value: " + averages813.largestSumOfAverages(A,k));
    }
}
