// 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]
// 
//
// 示例 2: 
//
// 
// 输入: nums = [1], k = 1
// 输出: [1]
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1894 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description 前 K 个高频元素
 * @Date 2024-09-19 12:04:02
 */
public class P347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 先遍历一遍数组，统计一下每个元素的出现次数。
     * 然后对出现次数进行堆排序
     * 如果选择大顶堆的话，要把所有次数入堆，然后再出堆k次。
     * 选择小顶堆的话，只需要建个k大小的堆，最后堆内的元素就是需要的元素了:
     * 如果堆内元素个数<k，那么直接入堆，如果==k, 比较堆顶元素的个数和新元素的个数，新元素次数多入堆
     */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // 统计出现次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums)
                map.put(num, map.getOrDefault(num, 0) + 1);

            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();
                if (heap.size() == k) {
                    if (heap.peek()[1] < count) {
                        heap.poll();
                        heap.offer(new int[]{num, count});
                    }
                } else
                    heap.offer(new int[]{num, count});
            }

            int[] res = new int[k];
            for (int i = 0; i < k; i++)
                res[i] = heap.poll()[0];
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}