package com.ligz.datastructure.array;

/**
 * 对角线遍历
 * @author ligz
 */
public class Diagonal {
	public int[] findDiagonalOrder(int[][] matrix) {
		boolean rightOrButton = true;//判断是向右，还是向下,true为右，false为下
		int[] na = new int[matrix.length * matrix[0].length];
		na[0] = matrix[0][0];
		int index = 1;
		int i = 0;
		int j = 0;
		while(i != matrix.length - 1 && j != matrix[0].length - 1) {
			if(rightOrButton && j < matrix[0].length) {//向右，且右边不为0
				j++;
				rightOrButton = false;
			}else if(!rightOrButton && i < matrix.length){//向下，且下边不为0
				i++;
				rightOrButton = true;
			}else if(rightOrButton) {
				j++;
				i--;
			}else {
				j--;
				i++;
			}
			na[index] = matrix[i][j];
			index++;
		}
		return na;
    }	
}
