// 给你一棵二叉树的根节点，返回该树的 直径 。
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,2,3,4,5]
// 输出：3
// 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
// 输入：root = [1,2]
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1603 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 二叉树的直径
 * @Date 2024-09-29 22:17:00
 */
public class P543DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();

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
     * 实际就是求左右子树的高度和，不过直径未必需要经过根节点，也就是说需要设置一个全局变量在遍历过程中保存一下
     * 最大的直径
     */
    class Solution {
        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return ans;
        }

        /**
         * 求树高的过程中计算一下直径
         * @param root
         * @return
         */
        private int dfs(TreeNode root) {
            if (root == null) return -1;    // 求得是路径长度不是节点个数，所以返回-1
            int leftLen = dfs(root.left) + 1;
            int rightLen = dfs(root.right) + 1;
            ans = Math.max(ans, leftLen + rightLen);
            return Math.max(leftLen, rightLen);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}