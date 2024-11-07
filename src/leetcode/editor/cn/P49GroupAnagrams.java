// 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2: 
//
// 
// 输入: strs = [""]
// 输出: [[""]]
// 
//
// 示例 3: 
//
// 
// 输入: strs = ["a"]
// 输出: [["a"]]
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 2028 👎 0

package leetcode.editor.cn;

import java.util.*;

/**
 * @Description 字母异位词分组
 * @Date 2024-10-29 12:23:04
 */
public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 哈希表
     * 所有的 字母异位词 排序后都是一样的，也就是说，只有排序后的字符串一样，
     * 这两个字符串才能分到一组。
     * 那么用排序后的字符串作为 key，原字符串组成列表当做 value
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);

                map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
            }

            return new ArrayList<>(map.values());
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}