package com.uchia.leetcode.dynamics.maxsubarray;

import java.util.TreeSet;

public class MaxSumSubMatrix363 {

    //bytedance
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= m; i++) {
            for (int p = i; p <= m; p++) {
                for (int j = 1; j <= n; j++) {
                    for (int q = j; q <= n; q++) {
                        int subMatrixSum = sum[p][q] - sum[i - 1][q] - sum[p][j - 1] + sum[i - 1][j - 1];
                        if (subMatrixSum > ans && subMatrixSum <= k) {
                            ans = subMatrixSum;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int t = 1; t <= n; t++) {
                    int right = sum[j][t] - sum[i - 1][t];
                    Integer left = set.ceiling(right - k);
                    if (left != null){
                        ans = Math.max(right - left,ans);
                    }
                    set.add(right);
                }
            }
        }
        return ans;
    }


    public int maxSumSubmatrix3(int[][] matrix, int k) {
        int row = matrix.length,col = matrix[0].length,max = Integer.MIN_VALUE;
        for (int i = 0;i < col;++i){
            int[] rowAry = new int[row];
            for (int j = i;j < col;++j){
                for (int m = 0;m < row;++m){
                    rowAry[m] += matrix[m][j];
                }
                max = Math.max(max,this.dpmax(rowAry,k));
                if (max == k) return k;
            }
        }
        return max;
    }
    private int dpmax(int[] arr, int k) {
        int last = arr[0],max = arr[0];
        for (int i = 1;i < arr.length;++i){
            if (last > 0){
                last += arr[i];
            }else {
                last = arr[i];
            }
            max = Math.max(max,last);
        }
        if (max <= k) return max;
        int aMax = Integer.MIN_VALUE;
        for (int i = 0;i < arr.length;++i){
            int aLast = 0;
            for (int j = i;j < arr.length;++j){
                aLast += arr[j];
                if (aLast > aMax && aLast <= k) aMax = aLast;
                if (aMax == k) return k;
            }
        }
        return aMax;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, -2, 1},
                {0, 0, 3}
        };
        MaxSumSubMatrix363 maxSumSubMatrix363 = new MaxSumSubMatrix363();
        System.out.println("max sum: " + maxSumSubMatrix363.maxSumSubmatrix2(matrix, 2));

    }

}
