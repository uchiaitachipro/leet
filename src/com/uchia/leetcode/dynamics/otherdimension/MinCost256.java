package com.uchia.leetcode.dynamics.otherdimension;

public class MinCost256 {
    // LinkedIn
    public int minCost(int[][] costs) {
        if (costs.length <= 0) {
            return -1;
        }
        int count = costs.length;
        int[][] dp = new int[count][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < count; i++) {
            for (int j = 0; j < 3; j++) {
                int rCost = j == 0 ? Integer.MAX_VALUE : dp[i - 1][0] + costs[i][j];
                int gCost = j == 1 ? Integer.MAX_VALUE : dp[i - 1][1] + costs[i][j];
                int bCost = j == 2 ? Integer.MAX_VALUE : dp[i - 1][2] + costs[i][j];
                dp[i][j] = Math.min(Math.min(rCost, gCost), bCost);
            }
        }

        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            cost = Math.min(dp[count - 1][i], cost);
        }
        return cost;
    }

}
