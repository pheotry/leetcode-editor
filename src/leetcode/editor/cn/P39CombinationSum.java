// 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
// 输入：candidates = [2,3,6,7], target = 7
// 输出：[[2,2,3],[7]]
// 解释：
// 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
// 7 也是一个候选， 7 = 7 。
// 仅有这两种组合。
//
// 示例 2： 
//
// 
// 输入: candidates = [2,3,5], target = 8
// 输出: [[2,2,2,2],[2,3,3],[3,5]]
//
// 示例 3： 
//
// 
// 输入: candidates = [2], target = 1
// 输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// Related Topics 数组 回溯 👍 2903 👎 0

package leetcode.editor.cn;

import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 组合总和
 * @Date 2024-10-11 12:54:19
 */
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P216CombinationSumIii} 组合总合III
     * 不同于组合总和3，这里每个元素是可以重复的
     */
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
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
                path.add(candidates[i]);
                target -= candidates[i];

                // 可以重复无非是下次还选当前元素，begin=i
                backtracking(candidates, target, i, path, res);

                // 恢复现场
                target += path.remove(path.size() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}