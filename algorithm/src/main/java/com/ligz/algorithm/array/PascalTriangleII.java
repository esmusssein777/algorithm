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
    /**
     * 目标：如何巧妙的构建杨辉三角
     * 分析：放 1 在头部，最后的 1 不会被修改，中间的值都是上一层相加，得出答案
     * 错误：无
     * 关键：先放 1 在头部，后面的都是上一层加起来的，list.size()没有变化，所以可以在原基础上直接循环修改
     * 复杂度：时间O(n^2)，空间O(n)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;
        list.add(0, 1);
        for (int i = 0; i < rowIndex; i++){
            list.add(0, 1);//先在原基础上将list的size加 1，所以头尾的1都不会变
            for (int j = 1; j < list.size() - 1; j++){
                list.set(j, list.get(j) + list.get(j + 1));//放在原位置上，list.size()没有变化
            }
        }
        return list;
    }
}
