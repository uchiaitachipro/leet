package com.uchia.leetcode.top100;

import java.util.Arrays;

public class ProductExceptSelf238 {
    // facebook amazon microsoft
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int reverseProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 < nums.length) {
                reverseProduct *= nums[i + 1];
            }
            result[i] *= reverseProduct;
        }

        return result;
    }


    public static void main(String[] args) {
        ProductExceptSelf238 self238 = new ProductExceptSelf238();


        System.out.println("result: " + Arrays.toString(self238.productExceptSelf(
                new int[]{
                        1, 2, 3, 4
                }
        )));
    }

}
