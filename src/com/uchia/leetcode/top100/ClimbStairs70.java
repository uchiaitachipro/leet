package com.uchia.leetcode.top100;

public class ClimbStairs70 {
    // bytedance amazon google
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;

        for (int i = 2; i < n + 2; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n + 1];
    }

    public static void main(String[] args) {
        ClimbStairs70 climbStairs70 = new ClimbStairs70();
        System.out.println(" result: " +climbStairs70.climbStairs(3));
    }
}
