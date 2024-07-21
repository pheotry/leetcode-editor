//给你一个字符串 s ，请你反转字符串中 单词 的顺序。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。 
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。 
//
// Related Topics 双指针 字符串 👍 1180 👎 0

package leetcode.editor.cn;

/**
 * @Description [151]反转字符串中的单词
 * @Title [151]reverse-words-in-a-string
 * @Date 2024-07-20 10:23:41
 */
public class P151ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        String s = "the sky is blue";
        solution.reverseWords(s);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = trimSpace(s);

        reverse(sb, 0, sb.length() - 1);

        // 反转单词
        int left = 0;
        for (int right = 0; right < sb.length(); right++) {
            while (right < sb.length() && sb.charAt(right) != ' ')
                right++;
            reverse(sb, left, right - 1);
            left = right + 1;
        }

        return sb.toString();
    }

    /**
     * 去除多余空格
     * @param s
     * @return
     */
    private StringBuilder trimSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 去除首尾空格
        while (left <= right && s.charAt(left) == ' ')
            left++;
        while (left <= right && s.charAt(right) == ' ')
            right--;

        // 去除中间空格
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ')
                sb.append(c);
            else if (sb.charAt(sb.length() - 1) != ' ')
                sb.append(c);
            left++;
        }

        return sb;
    }

    /**
     * 反转 left-right 的部分
     * @param sb
     * @param left
     * @param right
     */
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, tmp);
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}