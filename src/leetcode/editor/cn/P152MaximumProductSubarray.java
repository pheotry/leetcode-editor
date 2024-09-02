// 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [2,3,-2,4]
// 输出: 6
// 解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
// 输入: nums = [-2,0,-1]
// 输出: 0
// 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2301 👎 0

package leetcode.editor.cn;

/**
 * @Description 乘积最大子数组
 * @Date 2024-09-02 12:09:40
 */
public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 以i结尾的最大乘积
     * 由于 负数 的存在，会导致最大值好最小值调换，因此需要分开维护最大和最小两个值
     * 对于i，  1.使用以i-1结尾的子数组后为最大（小）值，  2.不使用，也就是nums[i]为最大（小）值
     * 遍历数组，不断更新最大最小值即可
     * 初始化：1乘以任何数还为本身，初始化为1
     */
    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int res = Integer.MIN_VALUE;
            int curMax = 1;
            int curMin = 1;
            for (int i = 0; i < len; i++) {
                // 负数交换最大最小乘积
                if (nums[i] < 0) {
                    int tmp = curMax;
                    curMax = curMin;
                    curMin = tmp;
                }

                curMax = Math.max(curMax * nums[i], nums[i]);
                curMin = Math.min(curMin * nums[i], nums[i]);

                res = Math.max(res, curMax);
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}