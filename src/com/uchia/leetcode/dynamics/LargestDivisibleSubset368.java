package com.uchia.leetcode.dynamics;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset368 {
    //amazon bytedance facebook
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int maxSize = 1;
        int maxValue = nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        if (maxSize == 1) {
            result.add(nums[0]);
            return result;
        }

        for (int index = nums.length - 1; index >= 0 && maxSize > 0; index--) {
            if (maxValue % nums[index] == 0 && maxSize == dp[index]){
                maxValue = nums[index];
                maxSize--;
                result.addFirst(maxValue);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset368 subset368 = new LargestDivisibleSubset368();

        //[1,2]
        System.out.println(Arrays.toString(subset368.largestDivisibleSubset(new int[]{1,2,3}).toArray()));

        //[1,2,4,8]
        System.out.println(Arrays.toString(subset368.largestDivisibleSubset(new int[]{1,2,4,8}).toArray()));
    }
}
