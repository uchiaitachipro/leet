package com.uchia.leetcode.dynamics.maxsubarray;

import java.util.Arrays;

public class GetMaxMatrix {
    //bytedance
    public int[] getMaxMatrix(int[][] matrix) {
        int[] result = new int[4];

        int left = 0;
        int top = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int[] sumSum = new int[m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(sumSum, 0);
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = 0; k < m; k++) {
                    sumSum[k] += matrix[j][k];
                    if (sum > 0){
                        sum += sumSum[k];
                    } else {
                        left = i;
                        top = k;
                        sum = sumSum[k];
                    }

                    if (sum > maxSum){
                        maxSum = sum;
                        result[0] = left;
                        result[1] = top;
                        result[2] = j;
                        result[3] = k;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {-1,0},
                {0,-1}
        };

        GetMaxMatrix getMaxMatrix = new GetMaxMatrix();

        System.out.println(Arrays.toString(getMaxMatrix.getMaxMatrix(matrix)));

    }

}
