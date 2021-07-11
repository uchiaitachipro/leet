package com.uchia.leetcode.dynamics.rob;

public class MaxSizeSlices1388 {

    //Alibaba
    public int maxSizeSlices(int[] slices) {
        int[] array = new int[slices.length - 1];
        System.arraycopy(slices,0,array,0,slices.length - 1);
        int max1 = rob(array);
        System.arraycopy(slices,1,array,0,slices.length - 1);
        int max2 = rob(array);
        return Math.max(max1,max2);
    }

    private int rob(int[] nums) {
        int choiceCount = (nums.length + 1) / 3;
        int n = nums.length;
        int[][] choice = new int[n + 1][choiceCount + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= choiceCount; j++) {
                choice[i][j] = Math.max(choice[i - 1][j], (i - 2 >= 0 ? choice[i - 2][j - 1] : 0) + +nums[i - 1]);
            }
        }
        return choice[nums.length][choiceCount];
    }


    public static void main(String[] args) {
        MaxSizeSlices1388 maxSizeSlices1388 = new MaxSizeSlices1388();
        int[] pizza1 = new int[]{1,2,3,4,5,6};
        // 10
        System.out.println("max: " + maxSizeSlices1388.maxSizeSlices(pizza1));

        int[] pizza2 = new int[]{8,9,8,6,1,1};
        // 16
        System.out.println("max: " + maxSizeSlices1388.maxSizeSlices(pizza2));
    }

}
