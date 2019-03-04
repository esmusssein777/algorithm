package com.ligz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角二
 * author:ligz
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;
        list.add(0, 1);
        for (int i = 0; i < rowIndex; i++){
            list.add(0, 1);//先在原基础上将list的size加 1，所以头尾的1都不会变
            for (int j = 1; j < list.size() - 1; j++){
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
