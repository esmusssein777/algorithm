package com.ligz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * author:ligz
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0){
			return new ArrayList<>();
		}
		List<Integer> list = new ArrayList<>();
		int direction = 1;//右下左上分别对应1,2,3,4
		int i = 0;
		int j = 0;
		list.add(matrix[0][0]);
		int row = matrix.length;
		int col = matrix[0].length;
		while(col != 0 && row != 0){
			//分成上下左右四种情况
			if(direction == 1){//右
				if(i == 0){
					for(int m = 0;m < col - 1; m++){
						j++;
						list.add(matrix[i][j]);
					}
				}else{
					for(int m = 0;m < col; m++){
						j++;
						list.add(matrix[i][j]);
					}
				}
				row--;
				direction = 2;
			}else if(direction == 2){
				for(int m = 0;m < row; m++){
					i++;
					list.add(matrix[i][j]);
				}
				col--;
				direction = 3;
			}else if(direction == 3){
				for(int m = 0;m < col; m++){
					j--;
					list.add(matrix[i][j]);
				}
				row--;
				direction = 4;
			}else{
				for(int m = 0;m < row; m++){
					i--;
					list.add(matrix[i][j]);
				}
				col--;
				direction = 1;
			}
		}
		return list;
	}

	/**
	 * 官方解答
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder2(int[][] matrix) {
		List ans = new ArrayList();
		if (matrix.length == 0) return ans;
		int R = matrix.length, C = matrix[0].length;
		boolean[][] seen = new boolean[R][C];
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int r = 0, c = 0, di = 0;
		for (int i = 0; i < R * C; i++) {
			ans.add(matrix[r][c]);
			seen[r][c] = true;
			int cr = r + dr[di];
			int cc = c + dc[di];
			if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
				r = cr;
				c = cc;
			} else {
				di = (di + 1) % 4;
				r += dr[di];
				c += dc[di];
			}
		}
		return ans;
	}

	/**
	 * 官方解答2
	 * @param matrix
	 * @return
	 */
	public List < Integer > spiralOrder3(int[][] matrix) {
		List ans = new ArrayList();
		if (matrix.length == 0)
			return ans;
		int r1 = 0, r2 = matrix.length - 1;
		int c1 = 0, c2 = matrix[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
			for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
			if (r1 < r2 && c1 < c2) {
				for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
				for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
			}
			r1++;
			r2--;
			c1++;
			c2--;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		SpiralMatrix matrix = new SpiralMatrix();
		matrix.spiralOrder(nums);
	}
}
