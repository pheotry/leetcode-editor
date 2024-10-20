// 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
// 输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
// 输入: candidates = [2,5,2,1,2], target = 5,
// 输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1594 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 组合总和 II
 * @Date 2024-10-11 20:36:20
 */
public class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 回溯: 枚举选哪个
     * {@link P39CombinationSum} 组合总和
     * 不同于 39组合总和，这里需要去重：同一层级不允许重复，不同层级允许重复，
     * 需要先对数组排序
     */
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            backtracking(candidates, target, 0, path, res);
            return res;
        }

        private void backtracking(int[] candidates, int target, int begin, List<Integer> path, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (target < 0)
                return;

            for (int i = begin; i < candidates.length; i++) {
                // 去重: i>begin保证了同层中数字相同时只选择第一个数字
                if (i > begin && candidates[i] == candidates[i - 1])
                    continue;

                path.add(candidates[i]);
                target -= candidates[i];

                backtracking(candidates, target, i + 1, path, res);

                // 恢复现场
                target += path.remove(path.size() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}