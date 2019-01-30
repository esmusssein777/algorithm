package com.ligz.algorithm.stack;

import java.util.*;

/**
 * 逆波兰表达式求值
 * author:ligz
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String val : tokens){
            if(set.contains(val)){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(cal(num2, num1, val));
            }else {
                stack.push(val);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private String cal(int a, int b, String c){
        int result = 0;
        switch (c){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if(b != 0) result = a / b;
                break;
        }
        return String.valueOf(result);
    }



    public static void main(String[] args) {
        String[] n = {"4","13","5","/","+"};
        EvalRPN e = new EvalRPN();
        e.evalRPN(n);
    }
}
