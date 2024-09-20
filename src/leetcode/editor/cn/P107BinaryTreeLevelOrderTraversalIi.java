// 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
// 输入：root = [1]
// 输出：[[1]]
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
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 810 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 二叉树的层序遍历 II
 * @Date 2024-09-20 12:05:39
 */
public class P107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();

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
     * {@link P102BinaryTreeLevelOrderTraversal} 不同于102，这里是逆序输出
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null)
                queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                res.add(0, tmp);
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}