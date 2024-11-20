// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
// 输出：[3,3,5,5,6,7]
// 解释：
// 滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1], k = 1
// 输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2928 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 滑动窗口最大值
 * @Date 2024-11-12 12:02:35
 */
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 单调队列：
     * 保持整个队列递减，那么窗口[i,j]滑动的时候会出现如下情况：
     * 1.j+1处的元素比队尾元素大，那么要弹出所有比他小的元素，把当前元素入队
     * 2.j+1处的元素比队尾元素小，那么直接入队
     * 3.i处的元素要被移除，如果==队头元素，则要移除队头
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> queue = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];   // 结果

            // 未形成窗口时
            for (int i = 0; i < k; i++) {
                // 移除队尾比当前元素小的元素
                while (!queue.isEmpty() && queue.getLast() < nums[i])
                    queue.removeLast();
                queue.addLast(nums[i]);
            }
            res[0] = queue.getFirst();

            // 形成窗口时, i为当前窗口有边界下一个元素
            for (int i = k; i < nums.length; i++) {
                // 要移除的元素为nums[i-k],判断是否为队头元素
                if (queue.getFirst() == nums[i - k])
                    queue.removeFirst();
                while (!queue.isEmpty() && queue.getLast() < nums[i])
                    queue.removeLast();
                queue.addLast(nums[i]);
                // 记录最大值
                res[i - k + 1] = queue.getFirst();
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}