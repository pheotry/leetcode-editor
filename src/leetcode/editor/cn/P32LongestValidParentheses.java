// 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
// 输入：s = "(()"
// 输出：2
// 解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
// 输入：s = ")()())"
// 输出：4
// 解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
// 输入：s = ""
// 输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2556 👎 0

package leetcode.editor.cn;

/**
 * @Description 最长有效括号
 * @Date 2024-09-03 09:55:26
 */
public class P32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 常规思路：使用栈直接记录下匹配的括号位置，然后排序，那么直接转换为查找最长连续子数组的问题了。
     * <p>
     * dp: On On
     * dp[i]表示以i结尾的最长有效括号长度为dp[i].
     * 1.对于s[i]='(',dp[i]=0, 我们只需要考虑s[i]=')'的情况即可, '('结尾不可能构成有效的括号；
     * 2.那么当s[i]=')'时：
     * 2.1 如果s[i-1]='(', 更新 dp[i]=dp[i-2]+2
     * 2.2 如果s[i-1]=')' 且 s[i-dp[i-1]-1]='(', 那么dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2].
     * dp[i-1]+2 表示以倒数第2个')', 也就是s[i-1]结尾的最长有效括号+s[i]这一对括号，
     * 然后再加上前面的有效括号个数 dp[i-dp[i-1]-2]
     */
    class Solution1 {
        public int longestValidParentheses(String s) {
            int len = s.length();
            int res = 0;
            int[] dp = new int[len];
            // s[0] 为'('时dp[0]=0, 为')'时不合法，dp[0]=0
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                    res = Math.max(res, dp[i]);
                }
            }
            return res;
        }
    }

    /**
     * 不用额外的空间 On O1
     * <p>
     * 从左到右遍历字符串，分别统计()的个数left, right：
     * 如果left<right,把它们清0
     * left=right时，计算合法括号个数
     * 但是这样会漏掉left始终>right的情况，我们可以从右到左再遍历一遍即可
     */
    class Solution {
        public int longestValidParentheses(String s) {
            int left = 0, right = 0, res = 0;
            // 从左到右遍历
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    left++;
                else
                    right++;
                if (left == right)
                    res = Math.max(res, 2 * left);
                else if (left < right)
                    left = right = 0;
            }
            // 从右到左遍历
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(')
                    left++;
                else
                    right++;
                if (left == right)
                    res = Math.max(res, 2 * left);
                else if (left > right)
                    left = right = 0;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}