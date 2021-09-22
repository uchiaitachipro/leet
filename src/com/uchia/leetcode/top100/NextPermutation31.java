package com.uchia.leetcode.top100;

import java.util.Arrays;

public class NextPermutation31 {

    /**
     * 漏掉break 终止搜索
     * @param nums
     */
    // facebook bytedance amazon
    public void nextPermutation(int[] nums) {
        int i = -1;

        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] < nums[j + 1]) {
                i = j;
                break;
            }
        }

        if (i >= 0) {
            int swapIndex = -1;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    swapIndex = j;
                    break;
                }
            }
            swap(i, swapIndex, nums);
        }

        reverse(i + 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        if (i < 0 || j < 0) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int start, int[] nums) {
        for (int i = start, j = nums.length - 1; i < j; i++, j--) {
            swap(i, j, nums);
        }
    }

    public static void main(String[] args) {
        NextPermutation31 permutation31 = new NextPermutation31();
        int[] arrays = new int[]{
                1
        };

        permutation31.nextPermutation(arrays);

        System.out.println("result: " + Arrays.toString(arrays));
    }
}
