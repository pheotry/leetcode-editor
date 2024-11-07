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
    class Solution1 {
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

    /**
     * 动态规划：
     * 对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，
     * 下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]。
     * 朴素的做法是对于数组 height 中的每个元素，分别向左和向右扫描并记录左边
     * 和右边的最大高度，然后计算每个下标位置能接的雨水量。
     * <p>
     * 上述做法的时间复杂度较高是因为需要对每个下标位置都向两边扫描。如果已经知道
     * 每个位置两边的最大高度，则可以在 O(n) 的时间内得到能接的雨水总量。使用动态
     * 规划的方法，可以在 O(n) 的时间内预处理得到每个位置两边的最大高度。
     * <p>
     * 使用两个数组preMax[n], sufMax[n]记录一下下标i左右两边的最高柱子高度
     */
    class Solution2 {
        public int trap(int[] height) {
            int len = height.length;
            // 分别计算前后最大高度数组
            int[] preMax = new int[len];
            preMax[0] = height[0];
            for (int i = 1; i < len; i++)
                preMax[i] = Math.max(preMax[i - 1], height[i]);
            int[] sufMax = new int[len];
            sufMax[len - 1] = height[len - 1];
            for (int i = len - 2; i >= 0; i--)
                sufMax[i] = Math.max(sufMax[i + 1], height[i]);

            int res = 0;
            for (int i = 0; i < len; i++) {
                // 累加每个柱子处可以装的水
                res += Math.min(preMax[i], sufMax[i]) - height[i];
            }

            return res;
        }
    }

    /**
     * 双指针：
     * 动态规划的做法中，需要维护两个数组 leftMax 和 rightMax，因此空间复杂度
     * 是 O(n)。是否可以将空间复杂度降到 O(1)？
     *
     * 注意到下标 i 处能接的雨水量由 leftMax[i] 和 rightMax[i] 中的最小值
     * 决定。由于数组 leftMax 是从左往右计算，数组 rightMax 是从右往左计算，
     * 因此可以使用双指针和两个变量代替两个数组。
     *
     * 维护两个指针 left 和 right，以及两个变量 leftMax 和 rightMax，初始时
     * left=0,right=n−1,leftMax=0,rightMax=0。指针 left 只会向右移动，
     * 指针 right 只会向左移动，在移动指针的过程中维护两个变量 leftMax
     * 和 rightMax 的值。
     *
     * 当两个指针没有相遇时，进行如下操作：
     * 1.使用 height[left] 和 height[right] 的值更新 leftMax 和 rightMax 的值；
     * 2.如果 height[left]<height[right]，则必有 leftMax<rightMax，
     * 下标 left 处能接的雨水量等于 leftMax−height[left]，将下标 left
     * 处能接的雨水量加到能接的雨水总量，然后将 left 加 1（即向右移动一位）；
     * 3.如果 height[left]≥height[right]，则必有 leftMax≥rightMax，
     * 下标 right 处能接的雨水量等于 rightMax−height[right]，将下标
     * right 处能接的雨水量加到能接的雨水总量，然后将 right 减 1（即向左移动一位）。
     *
     * 当两个指针相遇时，即可得到能接的雨水总量。
     */
    class Solution {
        public int trap(int[] height) {
            int res = 0;
            int left = 0, right = height.length - 1;
            int preMax = 0; // 前缀最大值，随着left右移更新
            int sufMax = 0; // 后缀最大值，随着right左移更新

            while (left < right) {
                preMax = Math.max(preMax, height[left]);
                sufMax = Math.max(sufMax, height[right]);

                if (preMax < sufMax)
                    res += preMax - height[left++]; // 计算left处雨水量
                else
                    res += sufMax - height[right--]; // 计算right处与水量
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}