// 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [1,2,3,4]
// 输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
// 输入: nums = [-1,1,0,-3,3]
// 输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 1900 👎 0

package leetcode.editor.cn;

/**
 * @Description 除自身以外数组的乘积
 * @Date 2024-11-17 12:23:39
 */
public class P238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new P238ProductOfArrayExceptSelf().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 前缀积*后缀积 n n
     * 分别计算前缀积和后缀积
     */
    class Solution1 {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;

            // 计算前缀积
            int[] pre = new int[len];
            pre[0] = 1;
            for (int i = 1; i < len; i++)
                pre[i] = nums[i - 1] * pre[i - 1];

            // 计算后缀积
            int[] suf = new int[len];
            suf[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--)
                suf[i] = nums[i + 1] * suf[i + 1];

            int[] res = new int[len];
            for (int i = 0; i < len; i++)
                res[i] = pre[i] * suf[i];

            return res;
        }
    }

    /**
     * 压缩空间, 前缀积直接计算，后缀积可以在计算结果的时候再计算
     */
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;

            // 计算前缀积
            int[] pre = new int[len];
            pre[0] = 1;
            for (int i = 1; i < len; i++)
                pre[i] = nums[i - 1] * pre[i - 1];


            int[] res = new int[len];
            int suf = 1;
            for (int i = len - 1; i >= 0; i--) {
                res[i] = pre[i] * suf;
                // 计算后缀积
                suf = suf * nums[i];
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}