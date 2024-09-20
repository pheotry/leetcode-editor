// 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
// 输入：root = []
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：root = [1]
// 输出：[1]
// 
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2139 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 二叉树的中序遍历
 * @Date 2024-09-19 22:51:18
 */
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);

        List<Integer> res = solution.inorderTraversal(root);
        System.out.println(res);
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
     * 递归
     */
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        private void inorder(TreeNode root, List<Integer> res) {
            if (root == null)
                return;
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    /**
     * 迭代法
     * {@link P144BinaryTreePreorderTraversal} 先序遍历
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}