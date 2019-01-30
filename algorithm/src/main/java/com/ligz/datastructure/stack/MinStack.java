package com.ligz.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * author:ligz
 */
public class MinStack {
    private List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        if(isEmpty()) return;
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int val : list){
            min = Math.min(val, min);
        }
        return min;
    }

    public boolean isEmpty(){
        if(list.size() == 0){
            return true;
        }
        return false;
    }
}
