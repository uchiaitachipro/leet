package com.uchia.leetcode.top100;

import java.util.Arrays;

public class CoinChange322 {

    /**
     * 1.和凑零钱最多种方案相混淆
     * 2.初始化问题，除了0种硬币 0面值初始化为1 其他应该是不合法数
     * @param coins
     * @param amount
     * @return
     */
    //microsoft amazon bytedance
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp,amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange322 coinChange322 = new CoinChange322();
        System.out.println("result: " + coinChange322.coinChange(new int[]{1, 2, 5}, 11));

        System.out.println("result: " + coinChange322.coinChange(new int[]{1}, 2));
    }
}
