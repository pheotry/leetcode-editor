// 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [1,2,3,4,5,6,7], k = 3
// 输出: [5,6,7,1,2,3,4]
// 解释:
// 向右轮转 1 步: [7,1,2,3,4,5,6]
// 向右轮转 2 步: [6,7,1,2,3,4,5]
// 向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
// 输入：nums = [-1,-100,3,99], k = 2
// 输出：[3,99,-1,-100]
// 解释:
// 向右轮转 1 步: [99,-1,-100,3]
// 向右轮转 2 步: [3,99,-1,-100]
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// Related Topics 数组 数学 双指针 👍 2275 👎 0

package leetcode.editor.cn;

/**
 * @Description 轮转数组
 * @Date 2024-11-17 12:10:43
 */
public class P189RotateArray {
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * n 1
     * 反转整个数组，再分别反转前k个元素，反转后n-k个元素
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k %= len;

            reverse(nums, 0, len - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, len - 1);
        }

        /**
         * 反转数组：左闭右闭区间
         *
         * @param nums
         * @param left
         * @param right
         */
        private void reverse(int[] nums, int left, int right) {
            while (left < right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}