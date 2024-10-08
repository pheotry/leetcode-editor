// 整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
// k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [4,5,6,7,0,1,2], target = 0
// 输出：4
// 
//
// 示例 2： 
//
// 
// 输入：nums = [4,5,6,7,0,1,2], target = 3
// 输出：-1
//
// 示例 3： 
//
// 
// 输入：nums = [1], target = 0
// 输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 3004 👎 0

package leetcode.editor.cn;

/**
 * @Description 搜索旋转排序数组
 * @Date 2024-09-11 12:06:04
 */
public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分查找，旋转后从中点分割后，有一部分必定是有序的，如果target在这里那就二分查找，不在就继续分割另一部分，然后重复二分
     * <p>
     * 方法2：一次二分找降序位置，然后再二分找target
     * {@link P153FindMinimumInRotatedSortedArray} 寻找旋转排序数组中的最小值
     */
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target)
                    return mid;
                // 前半部分有序【0， mid】
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid;
                    } else
                        left = mid + 1;
                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}