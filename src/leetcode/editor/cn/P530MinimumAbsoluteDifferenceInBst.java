// 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [4,2,6,1,3]
// 输出：1
// 
//
// 示例 2： 
// 
// 
// 输入：root = [1,0,48,null,null,12,49]
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
// nodes/ 相同
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 584 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 二叉搜索树的最小绝对差
 * @Date 2024-09-28 23:06:34
 */
public class P530MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();

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
     * BST中序遍历是个有序数组，然后遍历这个数组即可得到结果。
     * 实际处理过程中我们可以直接用一个pre记录上一个结点，这样就可以在
     * 遍历过程中计算最小值了
     */
    class Solution {
        TreeNode pre;    // 记录上一个结点
        int res;

        public int getMinimumDifference(TreeNode root) {
            pre = null;
            res = Integer.MAX_VALUE;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            if (pre != null)
                res = Math.min(res, root.val - pre.val);
            pre = root; // 记录上一个节点
            dfs(root.right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}