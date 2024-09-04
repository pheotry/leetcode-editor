// 给你一个字符串 s，找到 s 中最长的 回文 子串。
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
// 输入：s = "cbbd"
// 输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7323 👎 0

package leetcode.editor.cn;

/**
 * @Description 最长回文子串
 * @Date 2024-09-03 21:08:57
 */
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
        ;
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp：
     * dp[i][j]表示i-j是回文子串
     * dp[i+1,j-1]=true && s[i]=s[j] => dp[i][j]=true, 长度为2或3时，只需要s[i]=s[j]即可
     * 初始化：dp[i][i]=true
     * 遍历顺序：先遍历右节点在遍历左结点；如果先左节点后右节点的话，会导致在处理"aaaa"这种情况时,判断dp[0][3]时需要依赖dp[1][2]，
     * 但是此时dp[1][2]还未被更改.
     * 或者直接先遍历子串长度，然后遍历左结点，这样右节点也确定了
     */
    class Solution1 {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2)
                return s;
            // 记录结果左右边界
            int left = 0;
            int right = 0;
            int maxLen = 0; // 记录最大长度
            boolean[][] dp = new boolean[len][len];
            // 初始化
            for (int i = 0; i < len; i++)
                dp[i][i] = true;

            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            left = i;
                            right = j;
                            maxLen = j - i + 1;
                        }
                    }
                }
            }
            return s.substring(left, right + 1);
        }
    }

    /**
     * 中心扩展法：
     * 本质上就是遍历，然后分别以1个或2个字符作为起点，遍历整个字符串得到最终的回文串
     */
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            int maxLen = 0;
            int start = 0;
            // 左边界
            for (int i = 0; i < len; i++) {
                // 起点右边界：j=0,中心只有i，j=1，中心为i和i+1
                for (int j = 0; j <= 1; j++) {
                    int l = i;
                    int r = i + j;
                    // 向两边扩散
                    while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                        l--;
                        r++;
                    }
                    // 回溯到最长的回文串的位置
                    l++;
                    r--;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        start = l;
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}