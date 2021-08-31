package com.uchia.leetcode.top100;

import java.util.Arrays;

public class MaxArea11 {
    // bytedance amazon facebook
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = Integer.MIN_VALUE;
        while (left < right){
            int area = Math.min(height[left],height[right]) * (right - left);
            result = Math.max(result,area);
            if (height[left] <= height[right]){
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxArea11 area = new MaxArea11();
        System.out.println("result: "  + area.maxArea(new int[]{
                1,1
        }));

        System.out.println("result: "  + area.maxArea(new int[]{
                4,3,2,1,4
        }));

        System.out.println("result: "  + area.maxArea(new int[]{
                1,2,1
        }));
    }
}
