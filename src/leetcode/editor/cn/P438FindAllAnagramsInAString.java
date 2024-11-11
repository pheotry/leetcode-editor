// 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 
//
// 示例 1: 
//
// 
// 输入: s = "cbaebabacd", p = "abc"
// 输出: [0,6]
// 解释:
// 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
// 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
// 输入: s = "abab", p = "ab"
// 输出: [0,1,2]
// 解释:
// 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
// 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
// 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1535 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 找到字符串中所有字母异位词
 * @Date 2024-11-08 12:36:44
 */
public class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 先对p排序，然后逐步截取s，排序后看是否和排序后的p一致
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            char[] pCharArray = p.toCharArray();
            Arrays.sort(pCharArray);
            String pStr = new String(pCharArray);

            List<Integer> res = new ArrayList<>();

            int pLen = p.length();
            for (int start = 0; start + pLen <= s.length(); start++) {
                char[] chars = s.substring(start, start + pLen).toCharArray();
                Arrays.sort(chars);
                if (pStr.equals(new String(chars)))
                    res.add(start);
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}