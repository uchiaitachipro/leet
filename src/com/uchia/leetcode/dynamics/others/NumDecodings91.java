package com.uchia.leetcode.dynamics.others;

public class NumDecodings91 {
    // bytedance facebook google
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            int num = s.charAt(i - 1) - '0';
            if (num >= 1 && num <= 9) {
                dp[i] += dp[i - 1];
            }

            num = i >= 2 ? ((s.charAt(i - 2) -'0') * 10) + num : 0;
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NumDecodings91 decodings91 = new NumDecodings91();
        // 2
        String s = "12";
        System.out.println("count: " +decodings91.numDecodings(s));

        // 3
        s = "226";
        System.out.println("count: " +decodings91.numDecodings(s));

        // 0
        s = "0";
        System.out.println("count: " +decodings91.numDecodings(s));

        // 0
        s = "06";
        System.out.println("count: " +decodings91.numDecodings(s));
    }

}
