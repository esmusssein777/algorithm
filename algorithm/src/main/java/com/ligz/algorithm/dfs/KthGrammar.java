package com.ligz.algorithm.dfs;

import java.util.Arrays;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * 输入: N = 1, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 2
 * 输出: 1
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行:        0
 * 第二行:    0       1
 * 第三行:  0   1   1   0
 * 第四行: 0 1 1 0 1 0 0 1
 *
 * 第四层K=3的那个红色的左子结点，其父结点的位置是第三层的第 (K+1)/2 = 2个红色结点，
 * 而第四层K=6的那个蓝色幽子结点，其父节点的位置是第三层的第 K/2 = 3个蓝色结点。
 * 那么我们就可以一层一层的往上推，直到到达第一层的那个0。
 * 所以我们的思路是根据当前层K的奇偶性来确定上一层中父节点的位置，
 * 然后继续往上一层推，直到推倒第一层的0，然后再返回确定路径上每一个位置的值，这天然就是递归的运行机制啊。
 * 我们可以根据K的奇偶性知道其是左结点还是右结点，由于K是从1开始的，
 * 所以当K是奇数时，其是左结点，当K是偶数时，其是右结点。而且还能观察出来的是，
 * 左子结点和其父节点的值相同，右子结点和其父节点值相反
 * @author: ligz
 * 巨难无比
 */
public class KthGrammar {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K % 2 == 0) return kthGrammar(N - 1, K / 2) == 0 ? 1 : 0;
        else return kthGrammar(N - 1, (K + 1) / 2) == 0 ? 0 : 1;
    }
}
