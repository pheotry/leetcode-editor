// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 3
// 输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
// 输入：n = 1
// 输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3702 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 括号生成
 * @Date 2024-10-17 22:54:06
 */
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 回溯：把问题拆解一下：
     * 题目要的是合法的括号，我们先生成长度为n*2的所有排列，然后在其中找到合法的括号：
     * 记录左右括号的个数，只要(始终>=)，那么括号最终就会合法
     */
    class Solution {
        public List<String> generateParenthesis(int n) {
            StringBuilder path = new StringBuilder();   // 记录当前路径
            List<String> res = new ArrayList<>();

            backtracking(n, 0, 0, path, res);

            return res;
        }

        /**
         * 始终保持左括号>=右括号
         *
         * @param n
         * @param open  (个数
         * @param close )个数
         * @param path
         * @param res
         */
        private void backtracking(int n, int open, int close, StringBuilder path, List<String> res) {
            // if (open > n || close > n)
            //     return;
            if (path.length() == n * 2 && close == n) {
                res.add(path.toString());
                return;
            }
            // (个数<n才可以添加
            if (open < n) {
                path.append("(");
                backtracking(n, open + 1, close, path, res);
                path.deleteCharAt(path.length() - 1);
            }
            // )个数<(个数时才可以添加)
            if (close < open) {
                path.append(")");
                backtracking(n, open, close + 1, path, res);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}