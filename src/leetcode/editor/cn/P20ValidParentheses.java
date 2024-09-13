// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4536 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description 有效的括号
 * @Date 2024-09-13 12:24:11
 */
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        solution.isValid("){");
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 可以使用栈来匹配有效括号，遍历字符串，遇到左括号直接入栈，遇到右括号，栈顶元素匹配则弹出，否则匹配失败
     * <p>
     * 优化：1.奇数长度肯定不匹配
     * 2.使用map提前记录好括号的对应关系，这样可以省去大量的手写判断过程
     */
    class Solution {
        public boolean isValid(String s) {
            int len = s.length();
            if ((len & 1) == 1)
                return false;

            Map<Character, Character> pairs = new HashMap<>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};

            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (pairs.containsKey(c)) {
                    if (stack.isEmpty() || stack.peek() != pairs.get(c))
                        return false;
                    stack.pop();
                } else
                    stack.push(c);
            }
            return stack.isEmpty();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}