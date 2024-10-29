// 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
// 输入: nums = [2,3,0,1,4]
// 输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2645 👎 0

package leetcode.editor.cn;

/**
 * @Description 跳跃游戏 II
 * @Date 2024-10-27 16:19:45
 */
public class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心：n 1
     * 为了跳跃次数最少，需要保证每次找到最远的可到达距离
     * [2,3,1,1,4]: 本次跳跃最多为2，那么下一次跳跃起点为3或1，为了跳的更远，
     * 下一次应该从3起跳。
     * <p>
     * 具体实现：遍历数组，每次更新本次可跳跃的最远边界end, 到达边界时，更新边界
     * 并将跳跃次数+1；
     * 数组边界应该为倒数第2个元素（题目保证了一定可以到达终点）
     */
    class Solution {
        public int jump(int[] nums) {
            int len = nums.length;

            int steps = 0;
            int end = 0;    // 当前可以覆盖的最远距离
            int maxPos = 0; // 下一步可以覆盖的最远距离

            for (int i = 0; i <= len - 2; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (i == end) {
                    end = maxPos;
                    steps++;
                }
            }

            return steps;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}