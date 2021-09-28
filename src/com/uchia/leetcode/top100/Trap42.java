package com.uchia.leetcode.top100;

public class Trap42 {
    //amazon goldman facebook bytedance
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        for (int i = 0; i < height.length; i++){
            leftMax[i] = i > 0 ? Math.max(height[i],leftMax[i - 1]) : height[i];
        }

        for (int i = height.length - 1; i >= 0; i--){
            rightMax[i] = i < height.length - 1 ? Math.max(height[i],rightMax[i + 1]) : height[i];
        }


        int result = 0;

        for (int i = 0; i < height.length - 1; i++){
            result += Math.min(leftMax[i],rightMax[i]) - height[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Trap42 trap42 = new Trap42();

        System.out.println("result: " + trap42.trap(new int[]{
                4,2,0,3,2,5
        }));
    }
}
