package com.uchia.leetcode.dynamics.lis;

import java.util.Arrays;

public class LengthOfLIS300 {

    public int lengthOfLIS(int[] nums) {
        if (nums ==null || nums.length <= 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxLength = 1;

        for (int i = 0; i < nums.length; i++){
            int tempLength = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    tempLength = Math.max(tempLength,dp[j] + 1);
                    dp[i] = tempLength;
                }
            }
            if (tempLength > maxLength){
                maxLength = tempLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLIS300 lengthOfLIS300 = new LengthOfLIS300();
        // 1
        int[] nums1 = new int[]{7,7,7,7,7,7,7};
        System.out.println("count: " + lengthOfLIS300.lengthOfLIS(nums1));

        // 4
        nums1 = new int[]{0,1,0,3,2,3};
        System.out.println("count: " + lengthOfLIS300.lengthOfLIS(nums1));

        // 4
        nums1 = new int[]{10,9,2,5,3,7,101,18};
        System.out.println("count: " + lengthOfLIS300.lengthOfLIS(nums1));

        // 3
        nums1 = new int[]{4,10,4,3,8,9};
        System.out.println("count: " + lengthOfLIS300.lengthOfLIS(nums1));

        // 6
        nums1 = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println("count: " + lengthOfLIS300.lengthOfLIS(nums1));
    }
}
