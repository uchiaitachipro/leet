package com.uchia.leetcode.dynamics.others;

public class MinRefuelStops871 {
    //google bytedance
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target){
            return 0;
        }
        int k = stations.length;
        int[][] dp = new int[k + 1][k + 1];

        for (int i = 0; i <= k; i++) {
            dp[i][0] = startFuel;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i - 1][j] >= stations[i - 1][0]) {
                    dp[i][j] =  dp[i - 1][j];
                }
                if (dp[i - 1][j - 1] >= stations[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + stations[i - 1][1]);
                }
            }
        }

        int result = -1;
        for (int i = 1; i <= k; i++) {
            if (dp[k][i] >= target) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinRefuelStops871 minRefuelStops871 = new MinRefuelStops871();

        int[][] stations = new int[][]{
                {10, 100}
        };

        // -1
        System.out.println("count: " + minRefuelStops871.minRefuelStops(100, 1, stations));


        stations = new int[][]{
                {10, 60},
                {20, 30},
                {30, 30},
                {60, 40}
        };

        // 2
        System.out.println("count: " + minRefuelStops871.minRefuelStops(100, 10, stations));

        stations = new int[0][0];
        // 0

        System.out.println("count: " + minRefuelStops871.minRefuelStops(1, 1, stations));
    }
}
