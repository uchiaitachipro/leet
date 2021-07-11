package com.uchia.leetcode.dynamics.lis;

import java.util.Arrays;

public class MaxEnvelopes354 {
    // bytedance google microsoft
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length <= 0) {
            return 0;
        }

        Arrays.sort(envelopes, (array1, array2) -> {
            if (array1[0] == array2[0]) {
                return Integer.compare(array2[1], array1[1]);
            }
            return Integer.compare(array1[0], array2[0]);
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < envelopes.length; i++) {
            int[] envelope = envelopes[i];

            for (int j = 0; j < i; j++) {
                if(envelope[1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args){
        MaxEnvelopes354 maxEnvelopes354 = new MaxEnvelopes354();
        int[][] envelopes = new int[][]{
                {5,4},
                {6,4},
                {6,7},
                {2,3},
        };
        // 3
        System.out.println("count: " + maxEnvelopes354.maxEnvelopes(envelopes));

        envelopes = new int[][]{
                {1,1},
                {1,1},
                {1,1}
        };
        // 1
        System.out.println("count: " + maxEnvelopes354.maxEnvelopes(envelopes));

        envelopes = new int[][]{
                {1,3},
                {3,5},
                {6,7},
                {6,8},
                {8,4},
                {9,5}
        };

        // 3
        System.out.println("count: " + maxEnvelopes354.maxEnvelopes(envelopes));

        envelopes = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {3,5},
                {4,5},
                {5,5},
                {5,6},
                {6,7},
                {7,8}
        };

        // 7
        System.out.println("count: " + maxEnvelopes354.maxEnvelopes(envelopes));
    }
}
