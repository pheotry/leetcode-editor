// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为
// O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,0]
// 输出：3
// 解释：范围 [1,2] 中的数字都在数组中。
//
// 示例 2： 
//
// 
// 输入：nums = [3,4,-1,1]
// 输出：2
// 解释：1 在数组中，但 2 没有。
//
// 示例 3： 
//
// 
// 输入：nums = [7,8,9,11,12]
// 输出：1
// 解释：最小的正数 1 没有出现。
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 2235 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 缺失的第一个正数
 * @Date 2024-11-18 11:59:49
 */
public class P41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new P41FirstMissingPositive().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 排序后遍历一遍: nlogn 1
     * 设置一个数min=1，遍历过程中如果遇到和min相等的数则min++，最后返回min即可
     */
    class Solution1 {
        public int firstMissingPositive(int[] nums) {
            Arrays.sort(nums);
            // 排序后最大元素<=0
            if (nums[nums.length - 1] <= 0)
                return 1;
            int min = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == min)
                    min++;
            }
            return min;
        }
    }

    /**
     * 哈希表：n n
     * 把数组存入哈希表中，遍历 1-nums.lenth, 不在哈希表中的即为答案
     */
    class Solution2 {
        public int firstMissingPositive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums)
                set.add(num);
            for (int i = 1; i <= nums.length; i++) {
                if (!set.contains(i))
                    return i;
            }

            return nums.length + 1;
        }
    }

    /**
     * 原地哈希 n 1
     * 我们要找的数在[1,len+1],len是数组长度
     * len+1 可以不用找，前面[1,len] 都找到才返回 len+1
     * 为了方便查找 [1,len] 可以采用原地哈希的思路：把1放到 下标0 的位置，
     * 2放到 下标1 的位置。其实就是我们自己实现哈希表，使用数组哈希：
     * 把元素 i 映射到 下标i-1 的位置去
     * <p>
     * 具体实现：先遍历一遍数组，元素nums[i]在[1,len]范围内的情况下，
     * 检查nums[i]是否放在了正确的位置上如果不正确，那么要交换位置
     * 然后再遍历一遍数组（此时已经是哈希数组了），索引i中不是nums[i+1]，
     * 则直接返回索引i+1
     */
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;

            for (int i = 0; i < len; i++) {
                while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i])
                    swap(nums, nums[i] - 1, i);
            }

            for (int i = 0; i < len; i++) {
                if (nums[i] != i + 1)
                    return i + 1;
            }
            return len + 1;
        }

        /**
         * 交换元素
         *
         * @param nums
         * @param index1
         * @param index2
         */
        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}