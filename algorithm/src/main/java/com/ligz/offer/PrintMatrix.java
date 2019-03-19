package com.ligz.offer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * author:ligz
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int r1 = 0, c1 = 0;
        int r2 = matrix.length - 1;
        if (r2 < 0) return list;
        int c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {//没什么巧妙的方法，左下右上走一圈，再减去相应的量
            for (int c = c1; c <= c2; c++) list.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) list.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) list.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) list.add(matrix[r][c1]);
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return list;
    }
}
