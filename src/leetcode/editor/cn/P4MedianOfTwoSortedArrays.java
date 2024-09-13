// 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums1 = [1,3], nums2 = [2]
// 输出：2.00000
// 解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
// 输入：nums1 = [1,2], nums2 = [3,4]
// 输出：2.50000
// 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7220 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Description 寻找两个正序数组的中位数
 * @Date 2024-09-11 21:41:01
 */
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分查找：
     * 中位数：对于偶数找的是(m+n)/2，对于奇数长度，找的是(m+n)/2和(m+n)/2+1
     * 那么问题转化为求第k小的数：
     * 我们可以每次遍历直接排除掉k/2个数字：
     *
     * 1.我们直接比较两个数组k/2处的数字，如果A[k/2]<B[k/2]，那么直接排除掉A[start,k/2]，k-=k/2，
     * 2.如果 大于 ，那么排除掉B的那一部分
     * 3.如果相等，排除哪一部分都是可以的
     *
     * 边界处理：
     * 1.如果k/2>要排除的串的长度，那么只需要比较这个串最后一个字符和另一个串的k/2处的字符即可，k的更新也不能直接-k/2，
     * 应该减去实际排除长度
     * 2.k==1，此时排除最小的那个数就是要找的数
     *
     * 尾递归
     */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            System.out.println(Arrays.toString(nums1));
            System.out.println(Arrays.toString(nums2));
            int m = nums1.length;
            int n = nums2.length;
            int totalLen = m + n;
            // 奇数个
            if ((totalLen & 1) == 1) {
                int mid = (totalLen >> 1) + 1;
                return getKthElement(nums1, 0, m - 1, nums2, 0, n - 1, mid);
            } else {    // 偶数个
                int mid = totalLen >> 1;
                // int res = getKthElement(nums1, 0, m - 1, nums2, 0, n - 1, mid) + getKthElement(nums1, 0, m - 1, nums2, 0, n - 1, mid + 1);
                int res = getKthElement(nums1, 0, m - 1, nums2, 0, n - 1, mid);
                res += getKthElement(nums1, 0, m - 1, nums2, 0, n - 1, mid + 1);
                return res / 2.0;
            }
        }

        /**
         * 从两个有序数组中求第k小的个元素
         * 左闭右闭
         *
         * @param nums1  有序数组1
         * @param start1
         * @param end1
         * @param nums2  有序数组2
         * @param start2
         * @param end2
         * @return
         */
        private int getKthElement(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            // 保证len1的长度始终小于len2，这样就能保证如果有个数组空了，一定是第一部分的数组
            if (len1 > len2)
                return getKthElement(nums2, start2, end2, nums1, start1, end1, k);
            if (len1 == 0)
                return nums2[start2 + k - 1];

            if (1 == k)
                return Math.min(nums1[start1], nums2[start2]);

            int i = start1 + Math.min(len1, k >> 1) - 1;
            int j = start2 + Math.min(len2, k >> 1) - 1;

            if (nums1[i] < nums2[j])    // 排除nusm1[start1:i]
                return getKthElement(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            else
                return getKthElement(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}