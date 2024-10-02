// 给定一个二叉树，判断它是否是 平衡二叉树
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：root = [1,2,2,3,3,null,null,4,4]
// 输出：false
// 
//
// 示例 3： 
//
// 
// 输入：root = []
// 输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1552 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 平衡二叉树
 * @Date 2024-09-25 18:13:32
 */
public class P110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110BalancedBinaryTree().new Solution();

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
     * DFS: 自顶向下递归 O(n^2)
     */
    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            if (Math.abs(left - right) > 1)
                return false;
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int getHeight(TreeNode root) {
            if (root == null)
                return 0;
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    /**
     * DFS：后序遍历。自底向上，自顶向上有个问题，每个结点会被重复计算高度。
     * -1表示不平衡
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        private int getHeight(TreeNode root) {
            if (root == null)
                return 0;
            int leftHeight = getHeight(root.left);
            // 剪枝
            if (leftHeight == -1)
                return -1;
            int rightHeight = getHeight(root.right);
            // 不平衡
            if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
                return -1;
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}