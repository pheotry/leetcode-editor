// 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入：text1 = "abcde", text2 = "ace"
// 输出：3
// 解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
// 输入：text1 = "abc", text2 = "abc"
// 输出：3
// 解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
// 输入：text1 = "abc", text2 = "def"
// 输出：0
// 解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
//
// Related Topics 字符串 动态规划 👍 1607 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 最长公共子序列
 * @Date 2024-09-04 12:52:50
 */
public class P1143LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new P1143LongestCommonSubsequence().new Solution();
        Solution1 solution1 = new P1143LongestCommonSubsequence().new Solution1();
        solution.longestCommonSubsequence("abcde", "ace");
        // solution1.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"); // 5
        // solution.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"); // 5
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P718MaximumLengthOfRepeatedSubarray} 最长重复子数组
     * dp[i][j]表示 :i-1,:j-1最长公共子序列长度为dp[i][j]
     * dp[i][j]=dp[i-1][j-1]+1 <- nums1[i]=nums2[j], 如果不相等，那么dp[i][j]=max(dp[i-1][j],dp[i][j-1])
     */
    class Solution1 {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();

            int res = 0;
            int[][] dp = new int[len1 + 1][len2 + 1];

            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    // dp[i][j]是 :i-1 和 :j-1 中的最长公共子序列长度
                    if (text1.charAt(i - 1) == text2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    res = Math.max(res, dp[i][j]);
                }
                System.out.println(Arrays.toString(dp[i]));
            }
            return res;
        }
    }

    /**
     * 数组降维：因为只用到了i-1,j-1
     * 内层遍历顺序: 正序：需要的是当前行的数据那就正序，需要上一行的数据就倒序
     */
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            int[] dp = new int[len2 + 1];

            for (int i = 1; i <= len1; i++) {
                int prev = dp[0]; // 相当于dp[i-1][j-1]
                for (int j = 1; j <= len2; j++) {    // 正序：需要的是当前行的数据那就正序，需要上一行的数据就倒序
                    int temp = dp[j];
                    // dp[i][j]是 :i-1 和 :j-1 中的最长公共子序列长度
                    if (text1.charAt(i - 1) == text2.charAt(j - 1))
                        dp[j] = prev + 1;
                    else
                        dp[j] = Math.max(dp[j - 1], dp[j]); // j-1对应当前行左边的值，j对应上一行的值
                    // 更新dp[i-1][j-1]，为下次使用做准备
                    prev = temp;
                }
                // System.out.println(Arrays.toString(dp));;
            }
            return dp[len2];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}