package com.ligz.offer;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * author:ligz
 */
public class MovingCount {
    private int count = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digit;
    private int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] bool = new boolean[rows][cols];
        trace(bool, 0, 0);
        return count;
    }

    /**
     * 常规的递归计算走过的距离
     * @param bool 走过的路径
     * @param r
     * @param c
     */
    private void trace(boolean[][] bool, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || bool[r][c]) return;
        if (digit[r][c] > this.threshold) return;
        bool[r][c] = true;
        count++;
        for (int[] n : next) {
            trace(bool, r + n[0], c + n[1]);
        }
    }

    /**
     * 初始化整个数组，将每个点的横纵坐标加上，判断是否会大于 threshold
     */
    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digit = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digit[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }
}
