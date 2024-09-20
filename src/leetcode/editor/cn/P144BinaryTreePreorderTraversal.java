// 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
// 
//
// 示例 1： 
//
// 
// 输入：root = [1,null,2,3] 
// 
//
// 输出：[1,2,3] 
//
// 解释： 
//
// 
//
// 示例 2： 
//
// 
// 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9] 
// 
//
// 输出：[1,2,4,5,6,7,3,8,9] 
//
// 解释： 
//
// 
//
// 示例 3： 
//
// 
// 输入：root = [] 
// 
//
// 输出：[] 
//
// 示例 4： 
//
// 
// 输入：root = [1] 
// 
//
// 输出：[1] 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1277 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 二叉树的前序遍历
 * @Date 2024-09-19 22:11:24
 */
public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();

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
     * 递归法
     */
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorder(root, res);
            return res;
        }

        /**
         * 递归法
         *
         * @param root
         * @param res
         */
        private void preorder(TreeNode root, List<Integer> res) {
            if (root == null)
                return;
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }

    /**
     * 迭代法
     * {@link P94BinaryTreeInorderTraversal} 中序遍历
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    res.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}