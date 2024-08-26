//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2171 👎 0

package leetcode.editor.cn;

/**
 * @Description [209]长度最小的子数组
 * @Title [209]minimum-size-subarray-sum
 * @Date 2024-07-19 12:52:33
 */
public class P209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        return doublePointer(target, nums);
    }

    /**
     * 使用滑动窗口，遍历一遍数组，如果当前的和>=target，收缩窗口，更新窗口大小
     * @param target
     * @param nums
     * @return
     */
    public int doublePointer(int target, int[] nums) {
        int len = nums.length;
        int ans = len + 1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < len; right++) {
            sum = sum + nums[right];
            // 收缩窗口
            while (sum - nums[left] >= target)
                sum -= nums[left++];
            // 更新长度
            if (sum >= target)
                ans = Math.min(ans, right - left + 1);
        }
        return ans <= len ? ans : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}