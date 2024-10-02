// 给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：2
// 
//
// 示例 2： 
//
// 
// 输入：root = [2,null,3,null,4,null,5,null,6]
// 输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1220 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二叉树的最小深度
 * @Date 2024-09-20 16:50:39
 */
public class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();

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
     * 层序遍历
     * {@link P104MaximumDepthOfBinaryTree} 二叉树的最大深度
     */
    class Solution1 {
        public int minDepth(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            int res = 0;
            if (root != null)
                queue.offer(root);
            while (!queue.isEmpty()) {
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    // 叶子结点：最小深度
                    if (node.left == null && node.right == null)
                        return res + 1;

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                res++;
            }
            return res;
        }
    }

    /**
     * DFS
     */
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            // 存在一棵子树或是叶节点的情况
            if (left == 0 || right == 0)
                return left + right + 1;
            return Math.min(left, right) + 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}