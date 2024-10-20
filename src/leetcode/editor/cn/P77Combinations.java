// 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 4, k = 2
// 输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
// 输入：n = 1, k = 1
// 输出：[[1]]
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1683 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 组合
 * @Date 2024-10-10 21:00:46
 */
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 回溯法：组合
     * n叉树：对于 n = 4, k = 2:
     * 选 1，在[2,3,4]中选 2,3或4
     * 选 2，在[3.4]中选 3 或 4：上面1的情况已经选过了
     * 选3,4情况类似上面
     * <p>
     * 这对应着一颗 n=4叉树每次选择一个结点，树高为 k=2。
     * 那我们可以递归（深度搜索），从根节点到叶子结点，记录路径，然后回溯
     * 剪枝操作：n=4,k=2 时，第一次选4已经没有意义了，此时凑不够k个数了
     * i <= n - (k - path.size())
     */
    class Solution1 {
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> path = new ArrayList<>(); // 记录符合条件的路径
            List<List<Integer>> res = new ArrayList<>();    // 记录结果
            // 题目从 1 开始选
            backtracking(n, k, 1, path, res);
            return res;
        }

        private void backtracking(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
            // 当前路径符合长度为k
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            /*
             剪枝操作：i <= n - (k - path.size()) + 1
             当前已经选择了 path.size() 个数，还需要选择 k-path.size() 个数；
             也就是说当我们从 n - (k - path.size()) + 1 开始选的话已经无法
             凑够 k 个数了，
             */
            for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
                path.add(i);
                backtracking(n, k, i + 1, path, res);
                // 回溯，去掉最后一个数
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 对每一个数选或不选
     */
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> path = new ArrayList<>(); // 记录符合条件的路径
            List<List<Integer>> res = new ArrayList<>();    // 记录结果
            // 题目从 1 开始选
            backtracking(n, k, 1, path, res);
            return res;
        }

        private void backtracking(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
            // 当前路径符合长度为k
            if (k == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            // 剪枝
            if (begin > n - k + 1)
                return;

            // 不选当前数
            backtracking(n, k, begin + 1, path, res);

            // 选当前数字
            path.add(begin);
            backtracking(n, k - 1, begin + 1, path, res);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}