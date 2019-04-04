package com.ligz.offer;

/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 * author:ligz
 */
public class HasPath {
    private int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] map = new char[rows][cols];
        for (int i = 0, n = 0; i < rows; i++) {//构建二维的矩阵
            for (int j = 0; j < cols; j++) {
                map[i][j] = matrix[n++];
            }
        }
        boolean[][] bool = new boolean[rows][cols];//判断是否走过
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (trace(map, str, bool, 0, i, j)) return true;//从任意一格开始
            }
        }
        return false;
    }

    /**
     * 开始遍历整个矩阵
     * @param map 原始二维矩阵
     * @param str 匹配的字符
     * @param bool 是否已经遍历过
     * @param len 匹配字符的长度
     * @param i 走到的横坐标
     * @param j 走到的纵指标
     * @return
     */
    public boolean trace(char[][] map, char[] str, boolean[][] bool, int len, int i, int j) {
        if (len == str.length) return true;//如果字符全部匹配返回 true
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || bool[i][j] || map[i][j] != str[len]) {
            return false;//保证走的不出边界，不走重复，字符相等
        }
        bool[i][j] = true;
        for (int[] n : next) {//上下左右
            if (trace(map, str, bool, len + 1, i + n[0], j -  n[1])) return true;
        }
        bool[i][j] = false;
        return false;
    }
}
