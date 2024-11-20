// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出：6
// 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1]
// 输出：1
// 
//
// 示例 3： 
//
// 
// 输入：nums = [5,4,-1,7,8]
// 输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6834 👎 0

package leetcode.editor.cn;

/**
 * @Description 最大子数组和
 * @Date 2024-11-13 12:07:28
 */
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * n n
     * dp[i]表示以nums[i]结尾的最大子数组和
     * 如果 dp[i-1] < 0, 那么对 nums[i] 无帮助，直接从 nums[i] 开始，
     * 否则 dp[i] = dp[i-1]+nums[i]
     * <p>
     * 初始化：dp[0]=nums[0]: 表示以nums[0]结尾的最大子数组
     * <p>
     * 遍历顺序：dp[i]依赖dp[i-1]，从前往后遍历
     * <p>
     * 返回结果：dp[i]最大值
     */
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < len; i++) {
                if (dp[i - 1] < 0)
                    dp[i] = nums[i];
                else
                    dp[i] = dp[i - 1] + nums[i];

                res = Math.max(dp[i], res);
            }

            return res;
        }
    }

    /**
     * n 1 状态压缩
     * dp[i]的值只和前一个值有关，可以使用一个变量来代替
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int pre = nums[0];
            int res = pre;

            for (int i = 1; i < len; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                res = Math.max(res, pre);
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}