// 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
//
// 示例 2： 
//
// 
// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]
//
// 示例 3： 
//
// 
// 输入：nums = [], target = 0
// 输出：[-1,-1]
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2785 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @Date 2024-09-10 17:16:27
 */
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] a = new int[]{1, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(solution.searchRange(a, 7)));
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分查找: 注意：这里数组存在重复元素
     * 注：我们找第一个 大于等于 target 位置，二分的判断条件是 等于 的时候右指针也移动就行了，最后就可以找到第一个大于等于
     * target的位置了。
     * 找到的位置未必合理，需要判定一下
     * <p>
     * 可以使用常规二分查找，直接找 target-0.5和target+0.5，都找不到，返回要插入的位置即为start和end
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = lowBound(nums, target);
            if (start == nums.length || nums[start] != target)
                return new int[]{-1, -1};
            // start存在，end必定存在，这里找第一个大于等于 target+1 的元素，-1则是target的尾部
            int end = lowBound(nums, target + 1) - 1;
            return new int[]{start, end};
        }

        /**
         * 找到第一个大于等于target的元素；
         * 数组为空：返回0
         * 所有数据都小于target，则返回nums.length
         * 所有数据都大于target，则返回0
         *
         * @param nums
         * @param target
         * @return
         */
        private int lowBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return left;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}