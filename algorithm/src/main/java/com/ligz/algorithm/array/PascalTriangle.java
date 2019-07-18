package com.ligz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * author:ligz
 */
public class PascalTriangle {
	/**
	 * 目标：如何构建杨辉三角
	 * 分析：看似是迭代法，其实是有点带 dp 的感觉，每一层都是在上一层的构建基础上构建的，把前后的 1 都加上，稍微分析一下即可得出
	 * 错误：无
	 * 关键：不要搞错上一层和下一层的关系就不会出错
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allList = new ArrayList<>();
		if(numRows == 0){
			return allList;
		}
		allList.add(new ArrayList<>());
		allList.get(0).add(1);//先将1放入
		for(int i = 1; i < numRows; i++){
			List<Integer> list = new ArrayList<>();
			List<Integer> preList = allList.get(i-1);
			list.add(1);//先在前后都加上1
			if(preList.size() > 1){//将中间不为0的加进去
				for(int j = 0; j < preList.size() - 1; j++){
					list.add(preList.get(j) + preList.get(j+1));
				}
			}
			list.add(1);
			allList.add(list);
		}
		return allList;
	}
}
