// 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
// 输入：coins = [1, 2, 5], amount = 11
// 输出：3
// 解释：11 = 5 + 5 + 1
//
// 示例 2： 
//
// 
// 输入：coins = [2], amount = 3
// 输出：-1
//
// 示例 3： 
//
// 
// 输入：coins = [1], amount = 0
// 输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2871 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 零钱兑换
 * @Date 2024-09-01 09:56:58
 */
public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{474,83,404,3}, 264));
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 类似于 {@link P279PerfectSquares} 完全平方数
     * 硬币表示物品，amount表示背包容量，那么问题转换为完全背包问题
     * dp[j]表示装满容量为j的背包需要的最少硬币个数
     * dp[j]=min(dp[j-i]+1, dp[j]): 需要硬币i或不需要硬币i
     * 初始化：dp[0]=0
     * 遍历顺序：先背包后物品，或先物品后背包
     * <p>
     * 最差无非是amount全由硬币1组成，此时硬币数量最多为amount
     * 先背包后物品
     */
    class Solution1 {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 初始化
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            // 先背包后物品
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j])
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

    // 先物品后背包
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 初始化
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            // 先物品后背包
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    // if (j >= coins[i])
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}