package com.uchia.leetcode.dynamics.matrix;

public class MinPathSum64 {
    // bytedance google amazon
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        MinPathSum64 sum64 = new MinPathSum64();
        int[][] array = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("min: " + sum64.minPathSum(array));

        array = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("min: " + sum64.minPathSum(array));
    }
}
