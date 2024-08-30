//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 1397 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 整数拆分
 * @Date 2024-08-29 10:23:21
 */
public class P343IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new P343IntegerBreak().new Solution();
        solution.integerBreak(10);
        solution.integerBreak(2);
        solution.integerBreak(3);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 确定dp和下标含义：dp[i]表示拆分i后得到的最大乘积
     * 确定递推公式：拆成j和i-j, 然后继续拆分i-j => 从1开始遍历j，这个过程相当于j也被拆分过了
     * 初始化：dp[2]=1
     * 遍历顺序：从前往后
     * 举例推导：
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            // 拆分的越接近乘积越大
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i-j]));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}