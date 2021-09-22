package com.uchia.leetcode.top100;

public class SearchMatrixII240 {

    // bytedance microsoft amazon
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int r = row;
        int c = 0;

        while (r >=0 && c<= col ){
            if (matrix[r][c] > target){
                r--;
            } else if (matrix[r][c] < target){
                c++;
            } else {
                return true;
            }
        }
        return false;
    }
}
