// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 2
// 输出：2
// 解释：有两种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶
// 2. 2 阶
//
// 示例 2： 
//
// 
// 输入：n = 3
// 输出：3
// 解释：有三种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶 + 1 阶
// 2. 1 阶 + 2 阶
// 3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3591 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 爬楼梯
 * @Date 2024-08-26 12:53:50
 */
public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        solution.climbStairs(1);
        solution.climbStairs(2);
        solution.climbStairs(5);
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp：dp[i]表示爬到i阶的方法个数 On, On
     * dp[i]=dp[i-1]+dp[i-2]
     * dp[1]=1, dp[2]=2;
     * 从前往后遍历
     * dp[3]=dp1+dp2=1+2=3, dp4=5, dp5=8
     */
    class Solution1 {
        public int climbStairs(int n) {
            if (n <= 1)
                return n;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    /**
     * 压缩状态: 只和前两个状态有关系
     */
    class Solution {
        public int climbStairs(int n) {
            if (n <= 1)
                return n;
            int a = 1, b = 2, sum = 0;
            for (int i = 3; i <= n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println(b);
            return b;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}