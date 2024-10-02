// 给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,2,2,3,4,4,3]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：root = [1,2,2,null,3,null,3]
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2793 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 对称二叉树
 * @Date 2024-09-23 10:41:52
 */
public class P101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();

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
     * 对于对称二叉树：必定有对称结点left，right
     * 1.left.val=right.val，则此结点对称
     * 2.left.left.val=right.right.val
     * 3.left.right.val=right.left.val
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return root == null || recur(root.left, root.right);
        }

        private boolean recur(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null || left.val != right.val) return false;
            return recur(left.left, right.right) && recur(left.right, right.left);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}