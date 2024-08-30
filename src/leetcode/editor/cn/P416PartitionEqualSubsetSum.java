// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,5,11,5]
// 输出：true
// 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,5]
// 输出：false
// 解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2138 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 分割等和子集
 * @Date 2024-08-30 11:05:27
 */
public class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{1, 1}));
        System.out.println(solution.canPartition(new int[]{4, 4}));
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这道题可以看成从数组nums中选取一些数，然后他们的和为整个元素的一半，
     * 即转换为0-1背包问题：nums中的元素为物品，物品重量和价值都为nums[i], 背包容量为和的一半
     * <p>
     * dp[i][j]表示从[0,i]中选出若干元素，装入大小为j的背包，他们的最大价值为为dp[i][j]
     * 递推公式：对于元素nums[i], 如果背包容量 j<nums[i], 则不选nums[i], dp[i][j]=dp[i-1][j];
     * 如果背包容量 j>=nums[i], 则有两种选择：
     * 1. 不选nums[i], dp[i][j]=dp[i-1][j]
     * 2. 选nums[i], dp[i][j]=max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i])
     * 初始化：第一列背包容量为0，肯定为0了，第一行背包容量>=nums[0], 则可以存入nums[0]
     * 遍历顺序：先物品后背包
     *
     *
     * 剪枝：和为奇数不合题意，最大值超过背包容量不和题意
     */
    class Solution1 {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums)
                sum += num;
            if (sum % 2 == 1)
                return false;
            // 目标背包容量
            int target = sum / 2;
            int len = nums.length;
            int[][] dp = new int[len][target + 1];

            // 初始化第一行
            for (int i = nums[0]; i <= target; i++)
                dp[0][i] = nums[0];

            for (int i = 1; i < len; i++) {
                for (int j = 0; j <= target; j++) {
                    // 都是正整数, j=0时, 背包容量为0, 肯定为0, 相当于初始化了第一列
                    if (j < nums[i])
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }

            return dp[len - 1][target] == target;
        }
    }

    /**
     * 状态压缩：可以发现，我们只用到了上一层的值dp[i-1][j]
     * dp[j] = max(dp[j], dp[j-nums[i]+nums[i])
     *
     * 注：遍历顺序必须是先物品后背包，其次背包的遍历顺序必须是【从大到小】,如果从小到大，在计算dp[j]时，dp[j-nums[i]]
     * 已经被更新过了，不再是上一行的值，导致结果错误。
     */
    class Solution {
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            int sum = 0;
            for (int num : nums)
                sum += num;
            if (sum % 2 == 1)   // 奇数不和题意
                return false;
            // 目标背包容量
            int target = sum / 2;
            int[] dp = new int[target + 1];

            for (int i = 0; i < len; i++) {
                for (int j = target; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
                }
            }
            return dp[target] == target;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}