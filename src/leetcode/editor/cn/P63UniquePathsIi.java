// 一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// 输出：2
// 解释：3x3 网格的正中间有一个障碍物。
// 从左上角到右下角一共有 2 条不同的路径：
// 1. 向右 -> 向右 -> 向下 -> 向下
// 2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
// 输入：obstacleGrid = [[0,1],[0,0]]
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1281 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 不同路径 II
 * @Date 2024-08-27 12:43:22
 */
public class P63UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new P63UniquePathsIi().new Solution();
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp: {@link P62UniquePaths} 62.不同路径
     * 加上了障碍后，对应位置dp保持0即可；
     * 注：初始化时，障碍物后的地方也不能走了, 起点或终点有障碍物直接返回0
     * Omn Omn
     */
    class Solution1 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            // 起点或终点为障碍物
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
                return 0;
            int[][] dp = new int[m][n];
            // 初始化：障碍物后也不能到达
            for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++)
                dp[0][i] = 1;
            for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++)
                dp[i][0] = 1;

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) // 障碍物dp保持为0
                        continue;
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    /**
     * 状态压缩：{@link P62UniquePaths} 空间复杂度 On
     * 实际只用到了本层左边和上层的数，使用滚动数组记录即可
     *
     * dp[j]表示(0,0)到(i,j)的路径数
     * dp[j]=dp[j-1]+dp[j]，左边元素和上面元素（即更新前）
     * 初始化起点：根据障碍物初始化
     * 左到右，上到下遍历
     * 第一行: i=0, dp[j]=dp[j-1]+dp[j]相当于在上面虚拟了一行，没障碍物时更新，有障碍物为0
     * 第一列：j=0, 有障碍物为0，后面就始终为0了，没有障碍时，一直复用的起点值1
     * 其他位置：j>1 && 无障碍物：更新dp[j]
     */
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[] dp = new int[n];
            // 起点设置
            dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1)
                        dp[j] = 0;
                    else if (j > 0 && obstacleGrid[i][j-1] == 0)
                        dp[j] = dp[j] + dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}