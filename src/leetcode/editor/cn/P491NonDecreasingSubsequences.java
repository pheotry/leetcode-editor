// 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [4,6,7,7]
// 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
// 输入：nums = [4,4,3,2,1]
// 输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 816 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 非递减子序列
 * @Date 2024-10-13 10:55:37
 */
public class P491NonDecreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P491NonDecreasingSubsequences().new Solution();
        solution.findSubsequences(new int[]{4, 6, 7, 7});
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P90SubsetsIi} 子集II
     * 本题也是求递增子集，但是不能对原数组排序
     */
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtracking(nums, 0, path, res);
            return res;
        }

        private void backtracking(int[] nums, int begin, List<Integer> path, List<List<Integer>> res) {
            if (path.size() >= 2)
                res.add(new ArrayList<>(path));

            // 去重：这里使用数组哈希
            boolean[] used = new boolean[201];
            for (int i = begin; i < nums.length; i++) {
                if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || used[nums[i] + 100])
                    continue;
                // 不去重
                // if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);

                backtracking(nums, i + 1, path, res);

                path.remove(path.size() - 1);
                // }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}