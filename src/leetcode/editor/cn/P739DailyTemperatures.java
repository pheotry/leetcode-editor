// 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
// 在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
// 
//
// 示例 1: 
//
// 
// 输入: temperatures = [73,74,75,71,69,72,76,73]
// 输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
// 输入: temperatures = [30,40,50,60]
// 输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
// 输入: temperatures = [30,60,90]
// 输出: [1,1,0]
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1845 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 每日温度
 * @Date 2024-10-20 12:34:28
 */
public class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 单调栈：n n
     * 每个元素入栈出栈一次
     * 遍历温度，如果当前元素比栈顶元素大，则更新ans数组，弹出栈顶元素, 栈中
     * 存放元素下标
     */
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new LinkedList<>();
            int[] ans = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}