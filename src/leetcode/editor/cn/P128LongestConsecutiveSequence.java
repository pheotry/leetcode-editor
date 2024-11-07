// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [100,4,200,1,3,2]
// 输出：4
// 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2： 
//
// 
// 输入：nums = [0,3,7,2,5,8,4,6,0,1]
// 输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2255 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 最长连续序列
 * @Date 2024-10-31 11:56:00
 */
public class P128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 哈希表
     * 对于每个数x，我们枚举x+1，x+2。。。是否存在，即可找到以x开头的连续序列的长度，
     * 使用哈希表可以把这个检索优化到O(1)
     * 但是我们可以发现，我们做了许多重复判断，以x开头的和以x+1开头的子序列，
     * 会进行重复判断，但是以x+1开头的子序列我们在以x开头的子序列中已经判断过了，
     * 由于x的存在，以x+1开头的子序列长度肯定不是最长子序列。
     * 所以我们直接每次选择那些前面没有元素的数字进行查找即可。
     * <p>
     * 例：100前面的99不存在，那么以100开头以此枚举100+1,100+2是否在哈希表中，
     * 即可找到以100开头的最长子序列；4前面存在着3，3,2同理，则直接
     * 跳过4,3,2开头的子序列枚举
     */
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums)
                set.add(num);

            int longest = 0;
            for (int num : nums) {
                if (!set.contains(num - 1)) {
                    int curLen = 1;
                    int curNum = num;

                    while (set.contains(curNum + 1)) {
                        curLen++;
                        curNum++;
                    }

                    longest = Math.max(longest, curLen);
                }
            }

            return longest;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}