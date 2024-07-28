//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2254 👎 0

package leetcode.editor.cn;

/**
 * @Description 找出字符串中第一个匹配项的下标
 * @Date 2024-07-27 12:25:01
 */
public class P28FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new P28FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * {@link P459RepeatedSubstringPattern.Solution#kmp(String, String)}
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // 构建 next 数组
        int[] next = new int[m];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < m - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        // 匹配
        i = 0;
        j = 0;
        while (i < n && j < m) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == m)
            return i - j;
        else
            return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}