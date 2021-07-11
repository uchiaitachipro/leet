package com.uchia.leetcode.dynamics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestArithSeqLength1027 {
    // google facebook ebay
    public int longestArithSeqLength(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[][] dp = new int[nums.length][nums.length];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 2);
        }

        int maxValue = 2;

         for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int expireValue = 2 * nums[i] - nums[j];
                int index = map.getOrDefault(expireValue, -1);
                if (index >= 0) {
                    dp[i][j] = dp[index][i] + 1;
                    maxValue = Math.max(dp[i][j], maxValue);
                }
            }
            map.put(nums[i],i);
        }

        return maxValue;
    }


    public static void main(String[] args) {
        LongestArithSeqLength1027 longestArithSeqLength1027 = new LongestArithSeqLength1027();

        int[] array1 = new int[]{3, 6, 9, 12};
        //4
        System.out.println("count: " + longestArithSeqLength1027.longestArithSeqLength(array1));

        int[] array2 = new int[]{9, 4, 7, 2, 10};
        //3
        System.out.println("count: " + longestArithSeqLength1027.longestArithSeqLength(array2));

        int[] array3 = new int[]{20, 1, 15, 3, 10, 5, 8};
        //4
        System.out.println("count: " + longestArithSeqLength1027.longestArithSeqLength(array3));

        int[] array4 = new int[]{24, 13, 1, 100, 0, 94, 3, 0, 3};
        //2
        System.out.println("count: " + longestArithSeqLength1027.longestArithSeqLength(array4));

        int[] array5 = new int[]{0,8,45,88,48,68,28,55,17,24};
        //2
        System.out.println("count: " + longestArithSeqLength1027.longestArithSeqLength(array5));
    }
}
