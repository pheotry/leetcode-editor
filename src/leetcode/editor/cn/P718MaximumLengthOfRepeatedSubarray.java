// 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
// 输出：3
// 解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
// 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
// 输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 1106 👎 0

package leetcode.editor.cn;

/**
 * @Description 最长重复子数组
 * @Date 2024-09-04 19:31:17
 */
public class P718MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp[i][j]表示nums1[i],nums2[j]结尾的最长公共子数组长度
     * dp[i][j]=dp[i-1][j-1] + 1 <- nums1[i]=nums2[j]
     * 初始化：第一行和第一列有相等的元素就初始化为1，没有则初始化为0
     *
     * 如果dp[i][j]表示nums1[i-1],nums2[j-1]结尾的最长公共子数组长度: 初始化代码会更方便
     * {@link P1143LongestCommonSubsequence} 在 最长公共子序列中 可以看的更清楚
     */
    class Solution1 {
        public int findLength(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int res = 0;
            int[][] dp = new int[len1][len2];
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (nums1[i] == nums2[j]) {
                        if (i == 0 || j == 0)
                            dp[i][j] = 1;
                        else
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else
                        dp[i][j] = 0;

                    res = Math.max(res, dp[i][j]);
                }
            }
            return res;
        }
    }

    /**
     * 状态压缩：因为计算dp[i][j]时只和dp[i-1][j-1]有关，可以考虑压缩为一维数组，此时要倒序遍历，防止上一行数据被覆盖
     */
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int res = 0;
            int[] dp = new int[len2];
            // 初始化
            for (int i = 0; i < len2; i++) {
                if (nums1[0] == nums2[i]) {
                    dp[i] = 1;
                    res = 1;
                }
            }
            for (int i = 1; i < len1; i++) {
                for (int j = len2 - 1; j >= 0; j--) { // 这里是倒序
                    if (nums1[i] == nums2[j]) {
                        if (i == 0 || j == 0)
                            dp[j] = 1;
                        else
                            dp[j] = dp[j - 1] + 1;
                    } else
                        dp[j] = 0;

                    res = Math.max(res, dp[j]);
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}