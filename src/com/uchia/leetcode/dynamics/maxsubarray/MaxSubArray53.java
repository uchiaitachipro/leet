package com.uchia.leetcode.dynamics.maxsubarray;

public class MaxSubArray53 {
    // bytedance amazon microsoft apple
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int dp = nums[0];
        int maxSum = dp;
        for (int i = 1; i< nums.length; i++){
            dp = Math.max(nums[i],dp + nums[i]);
            if (dp > maxSum){
                maxSum = dp;
            }
        }
        return maxSum;
    }
}
