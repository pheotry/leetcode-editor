// 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,2]
// 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
// 输入：nums = [0]
// 输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1244 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 子集 II
 * @Date 2024-10-12 23:04:27
 */
public class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P78Subsets 子集}
     * 不同于 子集，这里的数组中允许重复元素
     */
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtracking(nums, 0, path, res);
            return res;
        }

        private void backtracking(int[] nums, int begin, List<Integer> path, List<List<Integer>> res) {
            res.add(new ArrayList<>(path));
            if (begin == nums.length)
                return;
            for (int i = begin; i < nums.length; i++) {
                // 去重
                if (i > begin && nums[i] == nums[i - 1])
                    continue;
                path.add(nums[i]);
                backtracking(nums, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}