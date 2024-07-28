//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 1191 👎 0

package leetcode.editor.cn;

/**
 * @Description 重复的子字符串
 * @Date 2024-07-28 09:43:40
 */
public class P459RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new P459RepeatedSubstringPattern().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // return BF(s);
        return kmp(s+s, s);
    }

    /**
     * 暴力匹配：只需要判断以0开头的子串是否可以构成s即可
     * 剪枝：1.子串长度最多为s的1/2，2.s长度可以整除子串长度
     * @param s
     * @return
     */
    private boolean BF(String s) {
        int len = s.length();

        // 重复子串最长为原串1/2
        for (int i = 0; i < len / 2; i++) {
            // 长度为i+1的子串不合条件
            if (len % (i + 1) != 0)
                continue;

            boolean match = true;
            // 只需要判断0-i的子串可否构成s即可
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) != s.charAt(j -  i - 1)) {
                    match = false;
                    break;
                }
            }
            if (match)
                return true;
        }
        return false;
    }

    /**
     * kmp
     * {@link P28FindTheIndexOfTheFirstOccurrenceInAString.Solution#strStr(String, String)}
     * @param s
     * @param p
     * @return
     */
    public boolean kmp(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        int i = 0;
        int j = -1;
        int[] next = new int[pLen];
        next[0] = -1;

        // 计算next数组
        while (i < pLen - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }

        // 排除首尾重复子串 i=1, i<sLen-1
        i = 1;
        j = 0;
        while (i < sLen - 1 && j < pLen) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];
        }
        if (j == pLen)
            return true;
        else
            return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}