package com.uchia.leetcode.top100;

public class Exist79 {

    /**
     * visited 数组来表示回溯选择，以及index + 1来判断是否完全匹配了
     * @param board
     * @param word
     * @return
     */
    // amazon microsoft bytedance
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        int[][] direction = new int[][]{
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };
        boolean[][] visited = new boolean[m][n];

        char[] words = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                if (backtrace(board, direction, visited, i, j, 0, words)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }


    private boolean backtrace(char[][] board, int[][] direction, boolean[][] visited, int x, int y, int currentIndex, char[] words) {

        int m = board.length;
        int n = board[0].length;

        if (board[x][y] != words[currentIndex]) {
            return false;
        }

        if (currentIndex + 1 == words.length) {
            return true;
        }

        for (int i = 0; i < direction.length; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (newX < 0 || newX >= m) {
                continue;
            }
            if (newY < 0 || newY >= n) {
                continue;
            }

            if (visited[newX][newY]) {
                continue;
            }

            visited[newX][newY] = true;
            if (backtrace(board, direction, visited, newX, newY, currentIndex + 1, words)) {
                return true;
            }
            visited[newX][newY] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        Exist79 exist79 = new Exist79();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("result: " + exist79.exist(board, "ABCCED"));


        System.out.println("result: " + exist79.exist(board, ""));
    }

}
