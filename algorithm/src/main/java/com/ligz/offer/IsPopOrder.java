package com.ligz.offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列
 * author:ligz
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int push : pushA) {
            stack.push(push);
            while (!stack.isEmpty()) {//模拟一波压入弹出，看最后是否为空
                if (stack.peek() == popA[index]) {
                    stack.pop();
                    index++;
                }else {
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}
