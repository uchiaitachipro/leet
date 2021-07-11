package com.uchia.leetcode.dynamics.twostrings;

public class IsMatch10 {
    // bytedance microsoft facebook
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == '*') {
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        } else{
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        IsMatch10 isMatch10 = new IsMatch10();

        System.out.println("is match: " + isMatch10.isMatch("aa","a"));

        System.out.println("is match: " + isMatch10.isMatch("aa","a*"));

        System.out.println("is match: " + isMatch10.isMatch("ab",".*"));

        System.out.println("is match: " + isMatch10.isMatch("aab","c*a*b"));

        System.out.println("is match: " + isMatch10.isMatch("","c*a*b*"));

        System.out.println("is match: " + isMatch10.isMatch("mississippi","mis*is*p*."));

    }
}
