// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [2,1,3]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：root = [5,1,4,null,null,3,6]
// 输出：false
// 解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2422 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 验证二叉搜索树
 * @Date 2024-09-28 18:11:55
 */
public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();

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
     * DFS: 二叉搜索树，左结点小于根，右结点大于根，左右子树也是一样的。
     * 二叉搜索树中序遍历为有序数组，可以判断数组是否有序来验证。
     * 注：1.不能简单判断左结点小于根，右结点大于根，如果这样递归的话示例2也会符合条件
     * 2.结点最小值为Integet.MIN_VALUE了，所以比较的话
     * <p>
     * 思路：我们知道左子树的所有结点小于根，右子树的值都大于根。
     * 根据这个特点，我们可以判断以root为根的二叉树，结点是否都在left,right区间内，递归定义
     * 左子树在left，root.val，右子树在root.val,right
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        /**
         * 树中所有结点的值在left,right之间
         *
         * @param root
         * @param left
         * @param right
         * @return
         */
        private boolean isValidBST(TreeNode root, long left, long right) {
            if (root == null) return true;
            long curVal = root.val;
            return left < curVal && curVal < right &&
                    isValidBST(root.left, left, curVal) &&
                    isValidBST(root.right, curVal, right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}