package com.uchia.leetcode.dynamics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LenLongestFibSubseq873 {
    // amazon google pdd

    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], 2);
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int fbValue = map.getOrDefault(arr[i] - arr[j], -1);
                if (fbValue != -1 && 2 * arr[j] > arr[i]) {
                    dp[i][j] = dp[j][fbValue] + 1;
                    maxValue = Math.max(maxValue,dp[i][j]);
                }
            }
        }
        return maxValue == Integer.MIN_VALUE ? 0 : maxValue;
    }


    public int lenLongestFibSubseq2(int[] arr) {
        int length = arr.length;

        int[][] dp = new int[length][length];
        int result = 0;

        for (int i = 2; i < length; i++) {
            int target = arr[i];
            int left = 0;
            int right = i - 1;

            while (left < right) {
                if (arr[left] + arr[right] < target) {
                    left++;
                } else if (arr[left] + arr[right] > target) {
                    right--;
                } else {
                    dp[right][i] = dp[left][right] + 1;
                    result = Integer.max(result,dp[right][i]);
                    left++;
                }
            }
        }
        return result > 0 ? result + 2 : 0;
    }


    public static void main(String[] args) {
        LenLongestFibSubseq873 fibSubseq873 = new LenLongestFibSubseq873();
        int[] fb1 = new int[]{1,2,3,4,5,6,7,8};
        System.out.println("count: " + fibSubseq873.lenLongestFibSubseq(fb1));



    }
}
