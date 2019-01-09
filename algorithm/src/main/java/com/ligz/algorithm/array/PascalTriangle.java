package com.ligz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * author:ligz
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		if(numRows == 0){
			List<List<Integer>> lists = new ArrayList<>();
			return lists;
		}
		List<List<Integer>> allList = new ArrayList<>();
		for(int i = 0; i < numRows; i++){
			List<Integer> list = new ArrayList<>();
			if(allList.size() == 0){//当没有值时，放入1
				list.add(1);
			}else {//当不为0
				List<Integer> preList = allList.get(i-1);
				list.add(1);//先在前后都加上0
				if(preList.size() > 1){//将中间不为0的加进去
					for(int j = 0; j < preList.size() - 1; j++){
						list.add(preList.get(j) + preList.get(j+1));
					}
				}
				list.add(1);
			}
			allList.add(list);
		}
		return allList;
	}
}
