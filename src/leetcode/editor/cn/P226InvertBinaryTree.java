// 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
// 输入：root = [2,1,3]
// 输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
// 输入：root = []
// 输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1866 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 翻转二叉树
 * @Date 2024-09-23 10:21:12
 */
public class P226InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();

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
     * BFS
     */
    class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            if (root != null)
                queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if ((node.right != null)) queue.offer(node.right);
                // 交换结点
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;


            }
            return root;
        }
    }

    /**
     * DFS
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return null;
            // 交换结点
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}