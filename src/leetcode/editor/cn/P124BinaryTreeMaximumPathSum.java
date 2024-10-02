// 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
// 经过根节点。
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,2,3]
// 输出：6
// 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
//
// 示例 2： 
// 
// 
// 输入：root = [-10,9,20,null,null,15,7]
// 输出：42
// 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2291 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 二叉树中的最大路径和
 * @Date 2024-10-02 11:28:57
 */
public class P124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();

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
     * {@link P543DiameterOfBinaryTree 二叉树的直径}
     * 维护一个全局变量，记录当前的最大值。
     * 知道了当前节点的最大贡献值，那么
     */
    class Solution {
        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        /**
         * 计算当前节点的最大贡献值: 指以该节点为起点的一条路径的最大值
         *
         * @param root
         * @return
         */
        private int maxGain(TreeNode root) {
            if (root == null) return 0;
            int leftGain = Math.max(maxGain(root.left), 0);
            int rightGain = Math.max(maxGain(root.right), 0);
            int priceGain = root.val + leftGain + rightGain;

            // 更新答案
            maxSum = Math.max(maxSum, priceGain);

            // 返回当前节点的最大贡献值
            return root.val + Math.max(leftGain, rightGain);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}