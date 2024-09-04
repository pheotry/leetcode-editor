// 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
// 输出：7
// 解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
// 输入：grid = [[1,2,3],[4,5,6]]
// 输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1707 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 最小路径和
 * @Date 2024-09-03 12:01:25
 */
public class P64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
        solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        solution.minPathSum(new int[][]{{1,2,3},{4,5,6}});
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp[i][j]表示到达i,j需要的最小和，只能往下或右移动，那么
     * dp[i][j]=min(dp[i-1][j]+grid[i-1][j], dp[i][j-1]+grid[i][j-1])
     * 初始化第一行第一列 dp[0][j], dp[i][0]
     */
    class Solution1 {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            // 初始化
            dp[0][0] = grid[0][0];
            for (int i = 1; i < n; i++) {
                dp[0][i] = grid[0][i] + dp[0][i - 1];
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
            for (int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
            return dp[m - 1][n - 1];
        }
    }

    /**
     * 状态压缩：因为只使用了上一行和左边的数据，所以把二维数组压缩为一维
     */
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] dp = new int[n];
            // 初始化
            for (int i = 0; i < n; i++) {
                dp[i] = grid[0][i] + (i == 0 ? 0 : dp[i - 1]);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0)
                        dp[j] = dp[j] + grid[i][j];
                    else
                        dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
            return dp[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}