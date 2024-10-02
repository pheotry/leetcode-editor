// 给定一个二叉树 root ，返回其最大深度。
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：3
// 
//
// 示例 2： 
//
// 
// 输入：root = [1,null,2]
// 输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1871 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 二叉树的最大深度
 * @Date 2024-09-20 16:50:05
 */
public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
    /**
     * 层序遍历 BFS
     */
    class Solution1 {
        public int maxDepth(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            int res = 0;
            if (root != null)
                queue.offer(root);
            while (!queue.isEmpty()) {
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();

                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                res++;
            }
            return res;
        }
    }

    /**
     * DFS: 后序遍历
     * 求深度应该用后序遍历，高度就是最大深度
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}