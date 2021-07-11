package com.uchia.leetcode.dynamics.stocks;

import java.util.Arrays;

public class MaxProfit188 {

    // bytedance amazon goldman sachs
    public int maxProfit(int k, int[] prices) {
        int count = prices.length;
        int[][][] dp = new int[count + 1][2][k + 1];
        if(count<=1)    return 0;
        k = Math.min(k, count / 2);
        Arrays.fill(dp[0][1], -prices[0]);
        Arrays.fill(dp[0][0], 0);

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i - 1]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i - 1]);
            }
        }

        return dp[count][0][k];
    }

    public static void main(String[] args) {
        MaxProfit188 profit188 = new MaxProfit188();

        System.out.println("max profit: " + profit188.maxProfit(2, new int[]{
                2, 4, 1
        }));

        System.out.println("max profit: " + profit188.maxProfit(2, new int[]{
                3, 2, 6, 5, 0, 3
        }));
    }
}
