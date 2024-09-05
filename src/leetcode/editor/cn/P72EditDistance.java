// 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：word1 = "horse", word2 = "ros"
// 输出：3
// 解释：
// horse -> rorse (将 'h' 替换为 'r')
// rorse -> rose (删除 'r')
// rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
// 输入：word1 = "intention", word2 = "execution"
// 输出：5
// 解释：
// intention -> inention (删除 't')
// inention -> enention (将 'i' 替换为 'e')
// enention -> exention (将 'n' 替换为 'x')
// exention -> exection (将 'n' 替换为 'c')
// exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3466 👎 0

package leetcode.editor.cn;

/**
 * @Description 编辑距离
 * @Date 2024-09-05 11:08:31
 */
public class P72EditDistance {
    public static void main(String[] args) {
        Solution solution = new P72EditDistance().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P1143LongestCommonSubsequence} 最长公共子序列
     * <p>
     * dp[i][j]: 表示以i-1,j-1 结尾的单词A,B，他们的最短编辑距离为dp[i][j]
     * 如果A[i-1]=B[j-1], 无需编辑 dp[i][j]=dp[i-1][j-1]
     * 如果A[i-1]!=B[j-1]，那么需要 添加 删除 替换 操作，我们可以发现，对A进行 添加（删除）操作和对 B进行 删除（添加）是等价的：
     * 对A删除元素 dp[i-1][j] + 1
     * 对B删除元素 dp[i][j-1] + 1
     * 替换元素 dp[i-1][j-1]+1
     * 选择最小的编辑方法即可
     * <p>
     * 初始化：非空串和空串，全删完两者才一致，所以初始化首行首列
     * 遍历顺序，左->右 上->下
     */
    class Solution1 {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];

            // 初始化
            for (int i = 0; i <= len1; i++)
                dp[i][0] = i;
            for (int i = 0; i <= len2; i++)
                dp[0][i] = i;

            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        // 替换 删除B 删除A
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
            return dp[len1][len2];
        }
    }

    /**
     * 空间优化：滚动数组
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int[] dp = new int[len2 + 1];

            // 初始化
            for (int i = 0; i <= len2; i++)
                dp[i] = i;

            for (int i = 1; i <= len1; i++) {
                int pre = dp[0];
                for (int j = 0; j <= len2; j++) {
                    int tmp = dp[j];
                    // 初始化第0列
                    if (j == 0)
                        dp[j] = i;
                    else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[j] = pre;
                    else
                        // 替换 删除B 删除A
                        dp[j] = j == 0 ? i : Math.min(pre, Math.min(dp[j - 1], dp[j])) + 1;
                    pre = tmp;
                }
            }
            return dp[len2];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}