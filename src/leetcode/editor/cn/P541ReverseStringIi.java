//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 611 👎 0

package leetcode.editor.cn;

/**
 * @Description [541]反转字符串 II
 * @Title [541]reverse-string-ii
 * @Date 2024-07-24 16:52:23
 */
public class P541ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new P541ReverseStringIi().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
// 每次操作 2k 个字符，前k个反转，不够2k，大于k同理，低于k则全部反转
class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] array = s.toCharArray();
        for (int pos = 0; pos < len; pos = pos + 2 * k) {
            if (pos + k < len) // 超过 k 个字符
                reverse(array, pos, pos + k - 1);
            else // 不足 k 个字符
                reverse(array, pos, len - 1);
        }
        return new String(array);
    }

    /**
     * 反转数组
     * @param array
     * @param left
     * @param right
     */
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left++] = array[right];
            array[right--] = tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}