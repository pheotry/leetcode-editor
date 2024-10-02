// 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
//
// 
//
// 示例 1： 
// 
// 
// 输入：nums = [-10,-3,0,5,9]
// 输出：[0,-3,9,-10,null,5]
// 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
// 输入：nums = [1,3]
// 输出：[3,1]
// 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1559 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 将有序数组转换为二叉搜索树
 * @Date 2024-09-29 21:40:59
 */
public class P108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    /**
     * {@link P654MaximumBinaryTree 最大二叉树} 根据数组构建树
     * {@link P106ConstructBinaryTreeFromInorderAndPostorderTraversal 从中序与后序遍历序列构造二叉树}
     *
     * 递归：题目要求的是平衡二叉搜索树，为了保证平衡，我们可以从树的中间作为分割点，然后递归地建立左子树和右子树。
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int len = nums.length;
            return dfs(nums, 0, len - 1);
        }

        /**
         * 递归地构造平衡二叉树
         * 左闭右闭区间
         *
         * @param nums
         * @param left
         * @param right
         * @return
         */
        private TreeNode dfs(int[] nums, int left, int right) {
            if (left > right) return null;

            int mid = left + ((right - left) >> 1);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, left, mid - 1);
            root.right = dfs(nums, mid + 1, right);
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}