// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
// 房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,3,2]
// 输出：3
// 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,1]
// 输出：4
// 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,2,3]
// 输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1616 👎 0

package leetcode.editor.cn;

/**
 * @Description 打家劫舍 II
 * @Date 2024-08-31 12:15:37
 */
public class P213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new P213HouseRobberIi().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P198HouseRobber} 打家劫舍基础上围成环了
     * 因为首尾相接，偷第一间就不能偷最后一间，偷最后一间就不能偷第一间, 那么问题就分成这两种情况，从环状退化为了线，
     * 分别求出两种情况下，取最大值
     */
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) return nums[0];
            // 偷第一家和偷最后一家：最后一家也可以选择不偷
            return Math.max(nums[0] + rob198(nums, 2, len - 1), rob198(nums, 1, len));
        }

        /**
         * {@link P198HouseRobber} 198.打家劫舍：线状
         * 左闭右开
         *
         * @param nums
         * @param start 房屋起点
         * @param end   房屋终点
         * @return 最大价值
         */
        private int rob198(int[] nums, int start, int end) {
            int pre = 0, cur = 0;
            for (int i = start; i < end; i++) {
                int tmp = cur;
                // 当前房屋选择偷或不偷
                cur = Math.max(pre + nums[i], cur);
                pre = tmp;
            }
            return cur;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}