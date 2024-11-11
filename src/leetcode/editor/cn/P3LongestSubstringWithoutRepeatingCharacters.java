// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
// 
//
// 示例 1: 
//
// 
// 输入: s = "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10416 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 无重复字符的最长子串
 * @Date 2024-11-08 12:02:12
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 滑动窗口+哈希表
     * 指针end依次遍历字符串并更新子串长度，如果遇到重复的字符，更新左指针的位置,
     * 此时左指针位置应该指向下一个位置。
     * 示例：abba, abcabcbb
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int start = 0;
            int maxLen = 0;

            for (int end = 0; end < s.length(); end++) {
                char ch = s.charAt(end);
                if (map.containsKey(ch)) {
                    // 有重复字符时，更新左指针
                    start = Math.max(start, map.get(ch) + 1);
                }
                // 更新长度
                maxLen = Math.max(maxLen, end - start + 1);
                map.put(ch, end);
            }

            return maxLen;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}