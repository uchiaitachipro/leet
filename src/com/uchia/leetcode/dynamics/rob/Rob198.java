package com.uchia.leetcode.dynamics.rob;

public class Rob198 {
    // bytedance amazon microsoft
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp_far = nums[0];
        int dp_neighbour = Math.max(nums[0],nums[1]);
        int max = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            int currentMax = Math.max(nums[i] + dp_far,dp_neighbour);
            dp_far = dp_neighbour;
            dp_neighbour = currentMax;
            max = Math.max(currentMax,max);
        }
        return max;
    }

    public static void main(String[] args) {
        Rob198 rob198 = new Rob198();
        int[] case1 = new int[]{1,2,3,1};
        //4
        System.out.println("max: " + rob198.rob(case1));

        int[] case2 = new int[]{2,7,9,3,1};
        // 12
        System.out.println("max: " + rob198.rob(case2));

        int[] case3 = new int[]{2,1,1,2};
        // 4
        System.out.println("max: " + rob198.rob(case3));
    }
}
