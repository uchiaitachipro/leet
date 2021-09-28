package com.uchia.leetcode.top100;

public class NumIslands200_UnionFind {


    /**
     * grid[i][j] = '0'; 搜索过后没有置为0
     * count 统计问题
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        UnionFind finder = new UnionFind(grid);

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    int currentIndex = i * col + j;

                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        int nextIndex = (i - 1) * col + j;
                        finder.union(currentIndex, nextIndex);
                    }

                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        int nextIndex = (i + 1) * col + j;
                        finder.union(currentIndex, nextIndex);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        int nextIndex = i * col + j - 1;
                        finder.union(currentIndex, nextIndex);
                    }

                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        int nextIndex = i * col + j + 1;
                        finder.union(currentIndex, nextIndex);
                    }

                }
            }
        }

        return finder.getCount();
    }

    final class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(char[][] data) {
            int row = data.length;
            int col = data[0].length;
            int size = row * col;

            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (data[i][j] == '1') {
                        int index = i * col + j;
                        parent[index] = index;
                        rank[index] = 0;
                        count++;
                    }
                }
            }
        }


        private int find(int num) {
            if (num != parent[num]) {
                parent[num] = find(parent[num]);
            }
            return parent[num];
        }


        private boolean isConnected(int num1, int num2) {
            return find(num1) == find(num2);
        }

        private void union(int num1, int num2) {
            int rootP = find(num1);
            int rootQ = find(num2);

            if (rootP == rootQ) {
                return;
            }

            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP] += 1;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}

        };

        NumIslands200_UnionFind numIslands200 = new NumIslands200_UnionFind();

        System.out.println("result: " + numIslands200.numIslands(grid));
    }

}
