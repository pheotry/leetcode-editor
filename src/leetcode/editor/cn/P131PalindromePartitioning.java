// 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "aab"
// 输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
// 输入：s = "a"
// 输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1868 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 分割回文串
 * @Date 2024-10-11 21:10:28
 */
public class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 实际问题可以拆分为 切割字符串+判断是否为回文串
     * 切割字符串实际就是组合
     * 判断回文串可以使用双指针
     * 为了避免重复，可以使用动态规划预先处理回文串
     */
    class Solution {
        public List<List<String>> partition(String s) {
            List<String> path = new ArrayList<>();  // 记录当前分割
            List<List<String>> res = new ArrayList<>(); // 记录结果
            backtracking(s, 0, path, res);
            return res;
        }

        private void backtracking(String s, int begin, List<String> path, List<List<String>> res) {
            // 终止条件
            if (begin == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = begin; i < s.length(); i++) {
                if (isPalindrome(s, begin, i)) {
                    path.add(s.substring(begin, i + 1));
                } else
                    continue;
                backtracking(s, i + 1, path, res);
                // 回溯
                path.remove(path.size() - 1);
            }
        }

        /**
         * 使用双指针判断s中[start,end]是否为回文串
         *
         * @param s
         * @param start
         * @param end
         * @return
         */
        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end))
                    return false;
                start++;
                end--;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}