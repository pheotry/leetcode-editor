// 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
// 输入: k = 3, n = 7
// 输出: [[1,2,4]]
// 解释:
// 1 + 2 + 4 = 7
// 没有其他符合的组合了。
//
// 示例 2: 
//
// 
// 输入: k = 3, n = 9
// 输出: [[1,2,6], [1,3,5], [2,3,4]]
// 解释:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// 没有其他符合的组合了。
//
// 示例 3: 
//
// 
// 输入: k = 4, n = 1
// 输出: []
// 解释: 不存在有效的组合。
// 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics 数组 回溯 👍 886 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 组合总和 III
 * @Date 2024-10-10 21:46:20
 */
public class P216CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new P216CombinationSumIii().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 回溯-组合
     * {@link P77Combinations} 组合
     */
    class Solution1 {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtracing(n, k, 1, path, res);
            return res;
        }

        private void backtracing(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
            if (k == path.size()) {
                if (n == 0)
                    res.add(new ArrayList<>(path));
                return;
            }

            /*
             剪枝：当前已添加 path.size() 个元素，还需要 k-path.size() 个，
             如果从 9 - (k - path.size()) + 1 开始选择，那么选不够 k 个元素了
             */
            for (int i = begin; i <= 9 - (k - path.size()) + 1; i++) {
                path.add(i);
                n -= i;
                backtracing(n, k, i + 1, path, res);
                // 恢复现场
                n += path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 选或不选
     */
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtracing(n, k, 1, path, res);
            return res;
        }

        private void backtracing(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
            if (k == 0) {
                if (n == 0)
                    res.add(new ArrayList<>(path));
                return;
            }
            // 剪枝：begin>9
            if (begin > 9 - k + 1)
                return;

            // 不选
            backtracing(n, k, begin + 1, path, res);
            // 选
            n -= begin;
            path.add(begin);
            backtracing(n, k - 1, begin + 1, path, res);
            // 恢复现场
            n += path.remove(path.size() - 1);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}