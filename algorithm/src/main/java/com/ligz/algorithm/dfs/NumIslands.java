package com.ligz.algorithm.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿的个数
 * author:ligz
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class NumIslands {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        if(m <= 0){
            return 0;
        }
        n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == '1'){//当遍历到1时，将旁边的1全部变为0
                    dfs(grid, i ,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i , int j){
        if(i < 0 || j < 0 || i > m - 1 || j > n - 1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
