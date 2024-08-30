// 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
// 
// 
// 输入：n = 3
// 输出：5
// 
//
// 示例 2： 
//
// 
// 输入：n = 1
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2534 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 不同的二叉搜索树
 * @Date 2024-08-29 10:49:23
 */
public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        solution.numTrees(3);
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 对于1-n，我们可以以i作为根节点，1~i-1作为左子树，i+1~n作为右子树, 然后以同样的方式构建左右子树；
     * 因为根节点不一样，所以构造的树不一样
     * 重叠子问题，可以尝试用动态规划来做
     * <p>
     * dp[i]表示1-i为为结点组成的二叉搜索树个数
     * dp[i]+=dp[j-1]*dp[i-j]: 以j为根,1~j-1为左子树，j+1~i为右子树
     * dp[0]=1, 空树
     * 从左到右
     */
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}