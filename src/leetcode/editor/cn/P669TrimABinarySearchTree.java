// 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不
// 应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
//
// 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,0,2], low = 1, high = 2
// 输出：[1,null,2]
// 
//
// 示例 2： 
// 
// 
// 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
// 输出：[3,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 10⁴] 内 
// 0 <= Node.val <= 10⁴ 
// 树中每个节点的值都是 唯一 的 
// 题目数据保证输入是一棵有效的二叉搜索树 
// 0 <= low <= high <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 961 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 修剪二叉搜索树
 * @Date 2024-09-29 16:57:25
 */
public class P669TrimABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P669TrimABinarySearchTree().new Solution();

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
     * 递归法：DFS，对当前树进行遍历，如果当前结点小于low，说明它和左子树不和题意，
     * 对其右子树进行修建；如果当前结点大于high，说明其右子树不和题意，对其左子树
     * 修剪
     */
    class Solution1 {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) return null;
            if (root.val < low)
                return trimBST(root.right, low, high);
            else if (root.val > high)
                return trimBST(root.left, low, high);
            else {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
                return root;
            }
        }
    }

    /**
     * 迭代法：从root出发，找第一个在[low,high]的节点，这个节点为最后要返回的
     * 根节点。
     * 针对左子树修剪掉小于low的节点，对右子树修剪掉大于high的节点。（二叉查找树
     * 只需要考虑一边的边界即可）
     * 这里只分析左子树left，右子树同理：
     * 如果左子树left==null，那么无需修剪；
     * 如果存在left.val<low, 那么left和其左边的节点都<low，直接修改
     * cur.left=cur.left.right,也就是修剪掉left和left的左子树；
     * 然后遍历右子树，如果右子树right存在且right.val>high，那么
     * cur.right=cur.right.left
     */
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            // 先找到第一个在[low,high]内的节点作为根节点
            while (root != null && (root.val < low || root.val > high))
                root = root.val < low ? root.right : root.left;

            TreeNode ans = root;

            // 修剪左子树
            while (root != null) {
                while (root.left != null && root.left.val < low)
                    root.left = root.left.right;
                root = root.left;
            }

            // 修剪右子树
            root = ans;
            while (root != null) {
                while (root.right != null && root.right.val > high)
                    root.right = root.right.left;
                root = root.right;
            }

            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}