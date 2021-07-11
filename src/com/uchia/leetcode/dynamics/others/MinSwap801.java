package com.uchia.leetcode.dynamics.others;

public class MinSwap801 {
    // google amazon huawei
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] keep = new int[n + 1];
        int[] swap = new int[n + 1];

        swap[1] = 1;

        for (int i = 2; i <= n; i++) {
            boolean condition1 = nums1[i - 1] > nums1[i - 2] && nums2[i - 1] > nums2[i - 2];
            boolean condition2 = nums1[i - 1] > nums2[i - 2] && nums2[i - 1] > nums1[i - 2];
            if (condition1 && condition2) {
                final int min = Math.min(keep[i - 1], swap[i - 1]);
                keep[i] = min;
                swap[i] = min + 1;
            } else if (condition1) {
                keep[i] = keep[i - 1];
                swap[i] = swap[i - 1] + 1;
            } else if (condition2) {
                keep[i] = swap[i - 1];
                swap[i] = keep[i - 1] + 1;
            }
        }
        return Math.min(keep[n], swap[n]);
    }

    public static void main(String[] args) {
        MinSwap801 swap801 = new MinSwap801();
        int[] nums1 = new int[]{1,3,5,4};
        int[] nums2 = new int[]{1,2,3,7};
        System.out.println("count: "+swap801.minSwap(nums1,nums2));
    }
}
