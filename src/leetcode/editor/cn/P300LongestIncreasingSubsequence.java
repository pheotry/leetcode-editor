// 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
// 序列。
//
// 示例 1： 
//
// 
// 输入：nums = [10,9,2,5,3,7,101,18]
// 输出：4
// 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [0,1,0,3,2,3]
// 输出：4
// 
//
// 示例 3： 
//
// 
// 输入：nums = [7,7,7,7,7,7,7]
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 3725 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 最长递增子序列
 * @Date 2024-09-02 10:38:44
 */
public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp[i]表示以nums[i]结尾的最长递增子序列长度为dp[i]
     * dp[i]=max(dp[j]+1, dp[i]): 1.nums[i]>nums[j], 符合题意，j从[0~i-1]中最大的dp[j], 2.nums[i]<nums[j],
     * 构不成递增子序列
     * 需要从0~i中选出最大的dp[j]，则每个dp[j]都要初始化为1，一个元素长度为1
     * 遍历顺序，遍历到每个数即可
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            int res = 1;
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}