// 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
// 输入: [3,2,1,5,6,4], k = 2
// 输出: 5
// 
//
// 示例 2: 
//
// 
// 输入: [3,2,3,1,2,4,5,5,6], k = 4
// 输出: 4
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2542 👎 0

package leetcode.editor.cn;

/**
 * @Description 数组中的第K个最大元素
 * @Date 2024-09-14 12:21:04
 */
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            buildMaxHeap(nums, heapSize);
            for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
                swap(nums, 0, i);
                --heapSize;
                maxHeapIfy(nums, 0, heapSize);
            }

            return nums[0];
        }

        private void buildMaxHeap(int[] a, int heapSize) {
            for (int i = heapSize / 2; i >= 0; i--)
                maxHeapIfy(a, i, heapSize);
        }

        private void maxHeapIfy(int[] a, int i, int heapSize) {
            int l = i * 2 + 1, r = i * 2 + 2, largest = i;

            if (l < heapSize && a[l] > a[largest])
                largest = l;
            if (r < heapSize && a[r] > a[largest])
                largest = r;

            if (largest != i) {
                swap(a, i, largest);
                maxHeapIfy(a, largest, heapSize);
            }
        }

        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}