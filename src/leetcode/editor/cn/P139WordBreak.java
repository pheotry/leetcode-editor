// 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true
// 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
// 输出: true
// 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// 输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2568 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description 单词拆分
 * @Date 2024-09-01 10:55:17
 */
public class P139WordBreak {
    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 词典是物品，字符串是背包，装满背包：完全背包
     * 求排列数：先背包后物品
     * dp[i]表示前i个字符是否可以由字典中的数据组成
     * 对于分割点j<i,如果dp[j]=true且[j,i]在字典中，那么dp[i]=true
     * 初始化dp[0]=true
     * 遍历顺序：先背包后物品
     *
     * 查找字典可以用set加快查询
     */
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            int len = s.length();
            // 初始化
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for (int i = 1; i <= len; i++) { // 先遍历背包
                for (int j = 0; j < i; j++) { // j为分割点
                    String word = s.substring(j, i);
                    if (dp[j] && set.contains(word))
                        dp[i] = true;
                }
            }

            return dp[len];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}