// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：digits = "23"
// 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
// 输入：digits = ""
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：digits = "2"
// 输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2919 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 电话号码的字母组合
 * @Date 2024-10-11 11:15:53
 */
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 组合：不同于{@link P77Combinations} 在一个集合中查找合适的组合，这里是在
     * 多个集合中查找, 实际就是求根到叶子的所有路径
     * <p>
     * 先使用map或者数组记录一下数字和字母的映射关系
     */
    class Solution {
        public List<String> letterCombinations(String digits) {
            // 处理数字和字母的映射关系
            String[] phoneMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            List<String> res = new ArrayList<>(); // 结果
            if (digits.isEmpty())
                return res;
            backtracking(phoneMap, digits, 0, new StringBuilder(), res);
            return res;
        }

        /**
         *
         * @param phoneMap 数字字母映射关系
         * @param digits 输入数字串
         * @param begin 当前数字的位置
         * @param path 记录当前路径
         * @param res 记录符合条件的路径
         */
        private void backtracking(String[] phoneMap, String digits, int begin, StringBuilder path, List<String> res) {
            // 终止条件
            if (path.length() == digits.length()) {
                res.add(path.toString());
                return;
            }
            // 获取当前数字对应的字符串
            String letters = phoneMap[digits.charAt(begin) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                // 把当前数字的第i个字符加入路径
                path.append(letters.charAt(i));
                // 递归处理下一个数字
                backtracking(phoneMap, digits, begin + 1, path, res);
                // 回溯
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}