package com.uchia.leetcode.dynamics.others;

public class NumberOfArithmeticSlices413 {
    // microsoft
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] += (dp[i - 1] + 1);
                sum += dp[i];
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        NumberOfArithmeticSlices413 slices413 = new NumberOfArithmeticSlices413();

        int[] array = new int[]{1, 3, 5, 7, 9};
        System.out.println("count: " + slices413.numberOfArithmeticSlices(array));

        // 3
        array = new int[]{1, 2, 3, 4};
        System.out.println("count: " + slices413.numberOfArithmeticSlices(array));
    }
}
