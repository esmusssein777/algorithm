package com.ligz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * author:ligz
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

	public static void main(String[] args) {
		int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		SpiralMatrix matrix = new SpiralMatrix();
		matrix.spiralOrder(nums);
	}
}
