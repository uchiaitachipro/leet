package com.uchia.leetcode.dynamics.maxsubarray;

public class MaxProduct152 {

    // bytedance LinkedIn Amazon Google
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] maxValues = new int[nums.length];
        int[] minValues = new int[nums.length];
        maxValues[0] = minValues[0] = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxValues[i] = Math.max(Math.max(maxValues[i - 1] * nums[i], minValues[i - 1] * nums[i]), nums[i]);
            minValues[i] = Math.min(Math.min(maxValues[i - 1] * nums[i], minValues[i - 1] * nums[i]), nums[i]);
            maxValue = Math.max(maxValue,maxValues[i]);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        MaxProduct152 maxProduct152 = new MaxProduct152();

        int[] nums = new int[]{2,3,-2,4};
        System.out.println("num: " + maxProduct152.maxProduct(nums));

        nums = new int[]{-2,0,-1};
        System.out.println("num: " + maxProduct152.maxProduct(nums));

        nums = new int[]{-2,3,-1,-1,-9};
        System.out.println("num: " + maxProduct152.maxProduct(nums));

    }

}
