// 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
// 输入：heights = [2,1,5,6,2,3]
// 输出：10
// 解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
// 输入： heights = [2,4]
// 输出： 4
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2809 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 柱状图中最大的矩形
 * @Date 2024-10-21 12:46:46
 */
public class P84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P42TrappingRainWater 接雨水}
     * 单调栈
     * 栈底到栈顶递增
     * 当前元素height[i] 低于栈顶元素高度，则出栈，以栈顶元素为高度计算左右两边的面积,
     * 当没有元素可入栈时，依次出栈，以该元素为高度计算左右两边的面积
     *
     * 对数组中的每个元素，若假定以它为高，能够展开的宽度越宽，那么以它为高的矩形面积就越大；
     * 这里是以栈顶元素为高, 右边面积+左边面积，求这个最大值
     */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<>();
            // !stack.isEmpty() && i == heights.length 对应栈中元素递增并且剩余元素已入栈
            for (int i = 0; i <= heights.length; i++) {
                while ((!stack.isEmpty() && i == heights.length) || (!stack.isEmpty() && heights[i] < heights[stack.peek()])) {
                    Integer top = stack.pop();
                    int rightArea = (i - top) * heights[top];
                    int leftArea = (stack.isEmpty() ? top : top - stack.peek() - 1) * heights[top];
                    ans = Math.max(ans, leftArea + rightArea);
                    System.out.println(top + " " + rightArea + " " + leftArea + " " + i);
                }
                stack.push(i);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}