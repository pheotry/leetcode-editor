// 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
// 示例 1：
//
// 
// 输入：s = "ababcbacadefegdehijhklij"
// 输出：[9,7,8]
// 解释：
// 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
// 每个字母最多出现在一个片段中。
// 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
//
// 示例 2： 
//
// 
// 输入：s = "eccbbbbdec"
// 输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1205 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 划分字母区间
 * @Date 2024-10-28 12:45:11
 */
public class P763PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new P763PartitionLabels().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P45JumpGameIi 跳跃游戏II}
     * 贪心：n 1
     * 找到每个字母的最远右边界，遍历数组，使用哈希表记录最远位置
     * 然后遍历数组，更新更新每一段的最远边界
     */
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int len = s.length();

            int[] hash = new int[26];   // 记录字母最远边界
            for (int i = 0; i < len; i++)
                hash[s.charAt(i) - 'a'] = i;

            List<Integer> partition = new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 0; i < len; i++) {
                end = Math.max(end, hash[s.charAt(i) - 'a']);
                if (i == end) {
                    partition.add(end - start + 1);
                    start = end + 1;
                }
            }

            return partition;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}