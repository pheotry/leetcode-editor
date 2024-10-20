// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3]
// 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2373 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 子集
 * @Date 2024-10-12 22:47:14
 */
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 子集是要遍历整棵树的
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
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
                path.add(nums[i]);
                backtracking(nums, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}