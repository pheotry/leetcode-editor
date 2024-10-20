// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
// 和 "192.168@1.1" 是 无效 IP 地址。
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
// 排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "25525511135"
// 输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
// 输入：s = "0000"
// 输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
// 输入：s = "101023"
// 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1453 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 复原 IP 地址
 * @Date 2024-10-12 18:38:22
 */
public class P93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P131PalindromePartitioning} 分割回文串
     * 相当于分割字符串然后再从中找到合法的ip串
     */
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> path = new ArrayList<>();
            List<String> res = new ArrayList<>();
            backtracking(s, 0, path, res);
            return res;
        }

        private void backtracking(String s, int begin, List<String> path, List<String> res) {
            // 分割的子串数大于4肯定不是ip了
            if (path.size() > 4)
                return;
            // 分割4个子串并且分割到末尾
            if (begin == s.length() && path.size() == 4) {
                StringBuilder sb = new StringBuilder();
                // 处理成ip
                for (int i = 0; i < 3; i++) {
                    sb.append(path.get(i))
                            .append(".");
                }
                sb.append(path.get(3));
                res.add(sb.toString());
                return;
            }

            for (int i = begin; i < s.length(); i++) {
                // 子串不能有前导0，但是可以为0
                if (s.charAt(begin) == '0') {
                    path.add("0");
                    backtracking(s, begin + 1, path, res);
                    path.remove(path.size() - 1);
                    break;
                }
                String sub = s.substring(begin, i + 1);
                if (Integer.parseInt(sub) > 255)
                    break;
                path.add(sub);
                backtracking(s, i + 1, path, res);
                // 恢复现场
                path.remove(path.size() - 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}