package com.ligz.offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * author:ligz
 */
public class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        if (node < min) {//将第二小的数再放进去一次，如果取出了最小的，那么最小的就会等于第二小的
            stack.push(min);
            min = node;
            stack.push(node);
            return;
        }
        stack.push(node);
    }

    public void pop() {
        if (min == stack.pop())
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
