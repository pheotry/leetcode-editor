// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出：6
// 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
// 
//
// 示例 2： 
//
// 
// 输入：height = [4,2,0,3,2,5]
// 输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5353 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 接雨水
 * @Date 2024-10-21 12:15:12
 */
public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 单调栈
     * 按行计算的, 栈底到栈顶递减
     * 当当前元素的高度不小于栈顶元素的高度时，此时栈顶元素即为凹槽, 记为top，栈顶下
     * 的元素为左边界，记为left，当前元素为右边界，
     * 则池子的高度为 左右边界最低高度-凹槽高度，
     * 宽度则为 右边界-左边界-1, 求和即可取得最终结果
     */
    class Solution {
        public int trap(int[] height) {
            Deque<Integer> stack = new LinkedList<>();
            int ans = 0;

            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = height[stack.pop()];
                    if (stack.isEmpty()) break;
                    int left = stack.peek();
                    // 计算宽度和高度
                    int w = i - left - 1;
                    int h = Math.min(height[left], height[i]) - top;

                    ans += h * w;
                }
                stack.push(i);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}