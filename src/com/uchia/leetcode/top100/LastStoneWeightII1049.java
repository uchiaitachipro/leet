package com.uchia.leetcode.top100;

public class LastStoneWeightII1049 {
    // facebook google cvte
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        int target = sum / 2;
        int m = stones.length;
        int[][] dp = new int[m + 1][target + 1];

        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - 2 * dp[m][target];
    }


    public static void main(String[] args) {
        LastStoneWeightII1049 weightII1049 = new LastStoneWeightII1049();

        System.out.println("min weight: " + weightII1049.lastStoneWeightII(new int[]{
                2, 7, 4, 1, 8, 1
        }));

        System.out.println("min weight: " + weightII1049.lastStoneWeightII(new int[]{
                31,26,33,21,40
        }));

        System.out.println("min weight: " + weightII1049.lastStoneWeightII(new int[]{
                1,2
        }));
    }
}
