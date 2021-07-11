package com.uchia.leetcode.dynamics.maxsubarray;

public class MaxSubarraySumCircular918 {
    public static void main(String[] args) {
        MaxSubarraySumCircular918 maxSubarraySumCircular918 = new MaxSubarraySumCircular918();

        int[] nums1 = {1, -2, 3, -2};
        // 3
        System.out.println("max sum: " + maxSubarraySumCircular918.maxSubarraySumCircular(nums1));

        nums1 = new int[]{5, -3, 5};
        // 10
        System.out.println("max sum: " + maxSubarraySumCircular918.maxSubarraySumCircular(nums1));

        nums1 = new int[]{3, -2, 2, -3};
        // 3
        System.out.println("max sum: " + maxSubarraySumCircular918.maxSubarraySumCircular(nums1));

        nums1 = new int[]{-2, -3, -1};
        // -1
        System.out.println("max sum: " + maxSubarraySumCircular918.maxSubarraySumCircular(nums1));
    }

    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int maxValue = A[0];
        int dpValue = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            dpValue = Math.max(dpValue + A[i], A[i]);
            maxValue = Math.max(dpValue, maxValue);
            sum += A[i];
        }

        int minValue = Integer.MAX_VALUE;
        dpValue = 0;
        for (int i = 1; i < A.length - 1; i++) {
            dpValue = Math.min(dpValue + A[i], A[i]);
            minValue = Math.min(dpValue, minValue);
        }
        return Math.max(sum - minValue, maxValue);
    }
}
