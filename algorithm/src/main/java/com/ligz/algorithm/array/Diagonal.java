package com.ligz.algorithm.array;

/**
 * 对角线遍历
 * @author ligz
 */
public class Diagonal {
	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return new int[0];
		}
		int[] na = new int[matrix.length * matrix[0].length];
		na[0] = matrix[0][0];
		int index = 0;
		int i = 0;
		int j = 0;
		while(index != matrix.length * matrix[0].length - 1) {
			if((i + j) % 2 == 0) {//横纵+为偶数，只能向右，向下，或者右上
				if(i == 0 && j < matrix[0].length - 1) {//向右
					j++;
				}else if(j == matrix[0].length - 1) {//向下
					i++;
				}else {//右上
					i--;
					j++;
				}
			}else {//奇数，向下，向右，向左上
				if(j == 0 && i < matrix.length - 1) {
					i++;
				}else if(i == matrix.length - 1){
					j++;
				}else {
					i++;
					j--;
				}
			}
			index++;
			na[index] = matrix[i][j];
		}
		return na;
    }

	/**
	 * LeetCode大神答案
	 * @param matrix
	 * @return
	 */
	public int[] findDiagonalOrder2(int[][] matrix) {//和我一毛一样。。。就是这也太短了。。。。。
		if (matrix.length == 0) return new int[0];
		int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = matrix[r][c];
			if ((r + c) % 2 == 0) { // moving up
				if      (c == n - 1) { r++; }
				else if (r == 0)     { c++; }
				else            { r--; c++; }
			} else {                // moving down
				if      (r == m - 1) { c++; }
				else if (c == 0)     { r++; }
				else            { r++; c--; }
			}
		}
		return arr;
	}
}
