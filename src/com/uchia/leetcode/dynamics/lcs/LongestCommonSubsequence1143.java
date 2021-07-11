package com.uchia.leetcode.dynamics.lcs;

public class LongestCommonSubsequence1143 {
    // bytedance tencent amazon
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (text1.charAt(i - 1) == text2.charAt(j -1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence1143 subsequence1143 = new LongestCommonSubsequence1143();

        System.out.println("max count: " + subsequence1143.longestCommonSubsequence("abcde","ace"));

        System.out.println("max count: " + subsequence1143.longestCommonSubsequence("abc","abc"));

        System.out.println("max count: " + subsequence1143.longestCommonSubsequence("abc","def"));
    }

}
