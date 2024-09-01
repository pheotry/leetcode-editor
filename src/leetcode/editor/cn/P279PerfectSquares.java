// 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 12
// 输出：3 
// 解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
// 输入：n = 13
// 输出：2
// 解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 2013 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 完全平方数
 * @Date 2024-08-31 21:16:20
 */
public class P279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P322CoinChange}
     *
     * 把完全平方数当作是物品（不限个数），n为背包容量，那么问题转化为把背包装满需要的物品最少数量
     * dp[j]表示装满容量为j的背包需要的最少物品数量为dp[j]
     * dp[j]=min(dp[j-i*i]+1, dp[j]), 对于物品i，可以选择或不选择
     * 初始化：dp[0]=0, 非0下标直接初始化为最大值即可
     * 遍历顺序：先物品后背包或先背包后物品都行
     * <p>
     * 先物品后背包
     */
    class Solution1 {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            // 遍历顺序：先物品后背包: 使用1-i*i的平方数装满容量为j的背包
            for (int i = 1; i * i <= n; i++) {
                for (int j = i * i; j <= n; j++) {
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
            return dp[n];
        }
    }

    // 先背包后物品
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            // 遍历顺序：先背包后物品
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
            return dp[n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}