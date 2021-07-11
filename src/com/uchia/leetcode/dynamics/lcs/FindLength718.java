package com.uchia.leetcode.dynamics.lcs;

public class FindLength718 {

    // bytedance amazon apple
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];

        int max = 0;
        for (int i = m - 1; i >=0 ;i--) {
            for (int j = n -1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j],max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        FindLength718 findLength718 = new FindLength718();
        System.out.println("count: " + findLength718.findLength(new int[]{
                1, 2, 3, 2, 1
        }, new int[]{
                3, 2, 1, 4, 7
        }));

        // 2
        System.out.println("count: " + findLength718.findLength(new int[]{
                0, 1, 1, 1, 1
        }, new int[]{
                1, 0, 1, 0, 1
        }));
    }
}
