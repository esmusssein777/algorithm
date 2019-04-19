package com.ligz.bytedance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 简化路径
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * author:ligz
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        //难想到这种方法，但是想到了的话比较好写，将字符放入stack中，如果遇到了 .. 就返回路径，也就是是push出来
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String p : paths) {
            if ("..".equals(p)) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                if (!set.contains(p)) stack.push(p);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return "".equals(res) ? "/" : res;
    }
}
