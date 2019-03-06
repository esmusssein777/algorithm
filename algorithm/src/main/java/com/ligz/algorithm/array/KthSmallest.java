package com.ligz.algorithm.array;

import java.util.Arrays;

/**
 * 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * k = 8,
 * 返回 13。
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {//使用范围形式的二叉搜索树
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = n - 1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
