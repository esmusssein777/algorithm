package com.ligz.algorithm.recursion;

/**
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 示例：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class ReverseString {
    /**
     * 目标：如何翻转整个数组，是迭代还是递归来遍历两个链表
     * 分析：递归将索引拿出来就行，迭代就更简单了，直接遍历即可
     * 错误：递归的时候想返回一个 char[]，发现递归的最后条件不知道 return 什么，才反应不需要 return ,void方法就行
     * 关键：理清终止条件
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        reverse(s, left, right);
    }

    private void reverse(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, left + 1, right - 1);
    }


    /**
     *  迭代的方法获取
     * 	public String reverseString(String s) {
     * 		if(s == null || "".equals(s)){
     * 			return "";
     *                }
     * 		char[] str = s.toCharArray();
     * 		int i = 0;
     * 		int j = s.length() - 1;
     * 		while (i < j){
     * 			swap(str, i, j);
     * 			i++;
     * 			j--;
     *        }
     * 		return new String(str);* 	}
     *
     * 	private void swap(char[] str, int i, int j){
     * 		char s = str[i];
     * 		str[i] = str[j];
     * 		str[j] = s;
     * 	}
     */
}
