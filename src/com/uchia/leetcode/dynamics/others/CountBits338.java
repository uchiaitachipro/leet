package com.uchia.leetcode.dynamics.others;

import java.util.Arrays;

public class CountBits338 {
    // bytedance amazon microsoft
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            count[i] = count[i >> 1] + (i & 1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountBits338 countBits338 = new CountBits338();

        System.out.println(Arrays.toString(countBits338.countBits(5)));
    }
}
