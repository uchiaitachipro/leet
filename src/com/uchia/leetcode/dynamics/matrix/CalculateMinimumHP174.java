package com.uchia.leetcode.dynamics.matrix;

public class CalculateMinimumHP174 {

    // shopee amazon google
    public int calculateMinimumHP(int[][] dungeon){
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++){
            dp[i][n] = Integer.MAX_VALUE;
        }

        for (int j =0; j <= n; j++){
            dp[m][j] = Integer.MAX_VALUE;
        }

        dp[m][n - 1] = dp[m - 1][n] = 1;


        for(int i = m - 1;i >=0; i--){
            for (int j = n - 1; j >= 0; j--){
                dp[i][j] = Math.max(Math.min(dp[i][j + 1],dp[i+ 1][j]) - dungeon[i][j] ,1);
            }
        }
        return dp[0][0];
    }
}
