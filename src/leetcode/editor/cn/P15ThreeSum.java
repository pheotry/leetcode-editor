// 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
// k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [-1,0,1,2,-1,-4]
// 输出：[[-1,-1,2],[-1,0,1]]
// 解释：
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
// 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
// 注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [0,1,1]
// 输出：[]
// 解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
// 输入：nums = [0,0,0]
// 输出：[[0,0,0]]
// 解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 7122 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 三数之和
 * @Date 2024-11-02 12:23:47
 */
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 双指针: 先对数组进行排序，然后遍历数组，选择第一个数nums[k]；
     * 使用双指针分别指向第一个数下一个数i=k+1, 和最后一个数j=nums.lenth-1;
     * 如果sum>0, 移动i指针，如果<0，移动j指针.
     * 
     * 对k去重，k>0&&nums[k]==nums[k-1]
     * 对i去重 while (i < j && nums[i] == nums[++i]);
     * 对j去重 while (i < j && nums[j] == nums[--j]);
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] > 0) break; // 不可能为0
                // 对k去重
                if (k > 0 && nums[k] == nums[k - 1])
                    continue;
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    // 不符合条件这部分的去重可以不加，加了是把判断逻辑提前了，但是对性能无影响
                    if (sum < 0)
                        // 对不符合条件的i去重
                        while (i < j && nums[i] == nums[++i]) ;
                    else if (sum > 0) {
                        // 对不符合条件的j去重
                        while (i < j && nums[j] == nums[--j]) ;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                        // 去重
                        while (i < j && nums[i] == nums[++i]);
                        while (i < j && nums[j] == nums[--j]);
                    }
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}