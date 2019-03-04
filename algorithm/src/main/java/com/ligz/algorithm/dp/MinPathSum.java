package com.ligz.algorithm.dp;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * author:ligz
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * 输出: 7
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        //int m = grid.length - 1;
        //int n = grid[0].length - 1;
        return dp(grid);
    }

    public int dp(int[][] grid) {//动态规划
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                if (i != 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public int dfs(int[][] grid, int m, int n) {//递归写法，超出时间
        if (m ==0 && n == 0) {
            return grid[m][n];
        }
        if (m != 0 && n == 0) {
            return grid[m][n] + dfs(grid, m - 1, n);
        }
        if (m == 0 && n != 0) {
            return grid[m][n] + dfs(grid, m, n - 1);
        }
        return grid[m][n] + Math.min(dfs(grid, m - 1, n), dfs(grid, m, n - 1));
    }
}
