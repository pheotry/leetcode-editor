// 给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "3[a]2[bc]"
// 输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
// 输入：s = "3[a2[c]]"
// 输出："accaccacc"
// 
//
// 示例 3： 
//
// 
// 输入：s = "2[abc]3[cd]ef"
// 输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
// 输入：s = "abc3[cd]xyz"
// 输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1833 👎 0

package leetcode.editor.cn;

import java.util.*;

/**
 * @Description 字符串解码
 * @Date 2024-09-13 19:57:39
 */
public class P394DecodeString {
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 本题的难点在于会出现 2[ab2[c]]这种嵌套情况，所以需要使用一个辅助栈来处理字符串。
     * 遇到数字就把次数入栈，遇到 [ 和 其他字符 就入栈，遇到 ] 就出栈，然后逆序，直到 [, 此时栈顶为这串字符的次数，构造好
     * 重复子串后继续入栈
     */
    class Solution {
        private int ptr = 0;

        public String decodeString(String s) {
            Deque<String> stack = new LinkedList<>();
            while (ptr < s.length()) {
                char cur = s.charAt(ptr);
                if (cur >= '0' && cur <= '9') { // 当前字符是个数字
                    // 获取数字
                    String digits = getDigits(s);
                    stack.push(digits);
                } else if (cur == ']') {    // ] 此时要出栈
                    // StringBuilder sb = new StringBuilder();
                    LinkedList<String> sb = new LinkedList<>();
                    while (!"[".equals(stack.peek()))
                        sb.addLast(stack.pop());
                    stack.pop();    // [ 出栈
                    // 构造重复子串
                    int count = Integer.parseInt(stack.pop());
                    StringBuilder sub = new StringBuilder();
                    String tmp = getString(sb);
                    while (count-- > 0)
                        sub.append(tmp);
                    // 重新入栈
                    stack.push(sub.toString());
                    ++ptr;
                } else {    // [ 或其他字符入栈
                    stack.push(String.valueOf(cur));
                    ++ptr;
                }
            }
            return getString(stack);
        }

        /**
         * 获取字符串中的数字
         *
         * @param s
         * @return 返回数字
         */
        private String getDigits(String s) {
            char c = s.charAt(ptr);
            StringBuilder sb = new StringBuilder();
            while (c >= '0' && c <= '9') {
                sb.append(c);
                ptr++;
                c = s.charAt(ptr);
            }
            return sb.toString();
        }

        private String getString(Deque<String> stack) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}