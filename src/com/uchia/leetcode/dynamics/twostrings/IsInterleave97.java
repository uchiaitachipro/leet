package com.uchia.leetcode.dynamics.twostrings;

public class IsInterleave97 {
    // apple google amazon
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != (m + n)) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = (s3.charAt(p) == s1.charAt(i - 1) && dp[i - 1][j]);
                }

                if (j > 0) {
                    dp[i][j] = dp[i][j] || (s3.charAt(p) == s2.charAt(j - 1) && dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        IsInterleave97 interleave97 = new IsInterleave97();
        System.out.println(interleave97.isInterleave(
                "aabcc",
                "dbbca",
                "aadbbcbcac"
        ));
    }
}
