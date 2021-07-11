package com.uchia.leetcode.dynamics.rob;

public class CircleRob213 {
    public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int dp_0 = 0;
        int dp_1 = 0;
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;
        for(int i = n - 2;  i >= 0; i--){
            int robValue = Math.max(dp_0,dp_1 + nums[i]);
            dp_1 = dp_0;
            dp_0 = robValue;
        }

        maxValue = Math.max(maxValue,dp_0);

        dp_1 = 0;
        dp_0 = 0;

        for (int i = n - 1; i >= 1; i--){
            int robValue = Math.max(dp_0,dp_1 + nums[i]);
            dp_1 = dp_0;
            dp_0 = robValue;
        }
        maxValue = Math.max(maxValue,dp_0);

        return maxValue;
    }


    public static void main(String[] args) {
        CircleRob213 rob213 = new CircleRob213();

        int[] case1 = new int[]{2,3,2};
        // 3
        System.out.println("max: " + rob213.rob(case1));

        int[] case2  = new int[]{1,2,3,1};
        // 4
        System.out.println("max: " + rob213.rob(case2));
    }
}
