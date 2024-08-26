// 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的最低花费。 
//
// 
//
// 示例 1： 
//
// 
// 输入：cost = [10,15,20]
// 输出：15
// 解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
// 总花费为 15 。
// 
//
// 示例 2： 
//
// 
// 输入：cost = [1,100,1,1,1,100,1,1,100,1]
// 输出：6
// 解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
// 总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// Related Topics 数组 动态规划 👍 1520 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 使用最小花费爬楼梯
 * @Date 2024-08-26 18:24:40
 */
public class P746MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P746MinCostClimbingStairs().new Solution();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        solution.minCostClimbingStairs(cost);
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp:
     * dp[i]表示爬到i阶时的最小花费
     * dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
     * dp[0]=0, dp[1]=0
     * 从左到右
     * dp[2]=0+1,0+100=1
     */
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            if (len < 2)
                return 0;

            int[] dp = new int[len+1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= len; i++)
                dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
            return dp[len];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}