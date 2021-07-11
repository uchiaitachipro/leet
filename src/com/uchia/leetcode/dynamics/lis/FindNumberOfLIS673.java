package com.uchia.leetcode.dynamics.lis;

import java.util.Arrays;

public class FindNumberOfLIS673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] +=count[j];
                    }
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < dp.length; i++) {
            if (maxLength < dp[i]) {
                maxLength = dp[i];
            }
        }
        int maxCount = 0;
        for (int j = 0; j < count.length; j++) {
            if (dp[j] == maxLength) {
                maxCount += count[j];
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        FindNumberOfLIS673 findNumberOfLIS673 = new FindNumberOfLIS673();

        // 2
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS673.findNumberOfLIS(nums));

        // 5
        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(findNumberOfLIS673.findNumberOfLIS(nums));

        // 3
        nums = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(findNumberOfLIS673.findNumberOfLIS(nums));
    }
}
