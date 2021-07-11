package com.uchia.leetcode.dynamics.matrix;

public class MaximalSquare221 {
    // amazon twitter bytedance
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int side = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = min(dp[i - 1][j],dp[i][j - 1],dp[i - 1][j -1]) + 1;
                }
                side = Math.max(dp[i][j],side);
            }
        }
        return side * side;
    }

    private int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    public static void main(String[] args) {
        MaximalSquare221 square221 = new MaximalSquare221();
        System.out.println("area: " +square221.maximalSquare(
                new char[][]{
                        {'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}
                }
        ));
    }
}
