// 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3]
// 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
// 输入：nums = [0,1]
// 输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
// 输入：nums = [1]
// 输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2976 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 全排列
 * @Date 2024-10-13 18:56:16
 */
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 全排列：不同于组合问题，排列是有顺序的，不同的顺序也是一个结果。
     * 每次都要从头搜索，不需要从begin开始搜索；
     * 所以需要一个数组来标记一下已使用过的元素
     */
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            backtracking(nums, used, path, res);
            return res;
        }

        private void backtracking(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;

                used[i] = true;
                path.add(nums[i]);

                backtracking(nums, used, path, res);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}