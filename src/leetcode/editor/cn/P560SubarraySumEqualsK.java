// 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,1,1], k = 2
// 输出：2
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3], k = 3
// 输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2492 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 和为 K 的子数组
 * @Date 2024-10-01 23:08:07
 */
public class P560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 前缀和+map
     *
     * 定义 pre[i] 表示 [0,i] 的和，则 pre[i] = pre[i-1] + nums[i]
     * 如果 [j,i] 的和为 k，那么可以转化为 pre[i] - pre[j-1] = k => pre[j-1]=pre[i]-k
     * 所以统计以 i 结尾的数组中有多少个和为 k 的子数组，只需要统计有多少个 前缀和 pre[j-1]
     * 遍历一遍数组，使用 哈希表 记录前缀和
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;  // 统计总数
            int preSum = 0; // 记录当前的前缀和
            Map<Integer, Integer> map = new HashMap<>();    // 记录前缀和和次数
            map.put(0, 1);  // 初始前缀和为0

            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                if (map.containsKey(preSum - k))
                    count += map.get(preSum - k);
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}