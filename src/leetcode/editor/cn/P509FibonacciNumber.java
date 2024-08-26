//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 775 👎 0

package leetcode.editor.cn;

/**
 * @Description 斐波那契数
 * @Date 2024-08-26 12:33:09
 */
public class P509FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new P509FibonacciNumber().new Solution();
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    /**
     * 递归解法
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2)
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }
}

class Solution2 {
    /**
     * 动态规划：非压缩版：
     * 1.确定dp[i]的含义：dp[i]表示第i个斐波那契数
     * 2.确定递推公式：dp[i]=dp[i-1]+dp[i-2]
     * 3.初始化：dp[0] = 0; dp[1] = 1;
     * 4.遍历顺序：从前往后
     * 5.举例推导dp数组
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}

class Solution {
    /**
     * 动态规划：压缩版：可以发现dp[i]只和前2个状态有关，那么我们只需要记录前2个状态即可
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2)
            return n;

        int a = 0, b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            // 更新前两个状态
            a = b;
            b = sum;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}