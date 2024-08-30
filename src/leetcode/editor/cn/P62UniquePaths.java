// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
// 
// 
// 输入：m = 3, n = 7
// 输出：28
//
// 示例 2： 
//
// 
// 输入：m = 3, n = 2
// 输出：3
// 解释：
// 从左上角开始，总共有 3 条路径可以到达右下角。
// 1. 向右 -> 向下 -> 向下
// 2. 向下 -> 向下 -> 向右
// 3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
// 输入：m = 7, n = 3
// 输出：28
// 
//
// 示例 4： 
//
// 
// 输入：m = 3, n = 3
// 输出：6
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
//
// Related Topics 数学 动态规划 组合数学 👍 2074 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 不同路径
 * @Date 2024-08-27 12:20:06
 */
public class P62UniquePaths {
    public static void main(String[] args) {
        Solution solution = new P62UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
        ;
        System.out.println(solution.uniquePaths(3, 2));
        ;
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp：i，j的路径数和上方、左边有关系
     * dp[i][j]表示到达i，j有多少条路径
     * dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * 初始化：边界为1
     * 左->右,上->下,遍历
     * 举例说明
     */
    class Solution1 {
        public int uniquePaths(int m, int n) {

            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++)
                dp[0][i] = 1;
            for (int i = 0; i < m; i++)
                dp[i][0] = 1;

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    /**
     * 状态压缩：
     * 可以发现dp[i]只和dp[i-1][j]和dp[i][j-1]有关系，那么我们可以使用滚动数组压缩状态
     * dp[j] = dp[j] + dp[j - 1]: dp[j-1]用的是左边的数据，dp[j]由于此时还未更新，相当于是上一行的数据
     */
    class Solution {
        public int uniquePaths(int m, int n) {

            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}