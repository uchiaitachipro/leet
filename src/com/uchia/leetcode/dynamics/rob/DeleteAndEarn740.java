package com.uchia.leetcode.dynamics.rob;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn740 {

    // Goldman sachs facebook  bytedance
    public int deleteAndEarn(int[] nums) {

        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if (maxValue < nums[i]){
                maxValue = nums[i];
            }
        }
        int[] sumArray = new int[maxValue + 1];
        for (int i = 0; i < nums.length; i++){
            sumArray[nums[i]] += nums[i];
        }

        int dp_0 = sumArray[0];
        int dp_1 = Math.max(sumArray[0],sumArray[1]);
        maxValue = Math.max(dp_0,dp_1);
        for (int i = 2; i < sumArray.length; i++){
            int currentMax = Math.max(dp_1,dp_0 + sumArray[i]);
            dp_0 = dp_1;
            dp_1 = currentMax;
            maxValue = Math.max(maxValue,currentMax);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        DeleteAndEarn740 deleteAndEarn740 = new DeleteAndEarn740();

        int[] case1 = new int[]{3,4,2};
        // 6
        System.out.println("result: " +deleteAndEarn740.deleteAndEarn(case1));

        int[] case2 = new int[]{2,2,3,3,3,4};
        // 9
        System.out.println("result: " +deleteAndEarn740.deleteAndEarn(case2));

        int[] case3 = new int[]{8,7,3,8,1,4,10,10,10,2};
        // 52
        System.out.println("result: " +deleteAndEarn740.deleteAndEarn(case3));
    }
}
