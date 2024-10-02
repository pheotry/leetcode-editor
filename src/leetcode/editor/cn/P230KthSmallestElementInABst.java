// 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,1,4,null,2], k = 1
// 输出：1
// 
//
// 示例 2： 
// 
// 
// 输入：root = [5,3,6,2,4,null,null,1], k = 3
// 输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 912 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 二叉搜索树中第 K 小的元素
 * @Date 2024-09-29 22:34:45
 */
public class P230KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new P230KthSmallestElementInABst().new Solution();
        List<Integer> list = Arrays.asList(3, 1, 4, null, 2);
        TreeNode root = TreeNode.buildTree(list);
        solution.kthSmallest(root, 1);
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
     * 中序遍历
     */
    class Solution {
        private int ans = 0;
        private int count = 0;

        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);
            return ans;
        }

        private void dfs(TreeNode root, int k) {
            if (root == null) return;
            dfs(root.left, k);
            count++;
            if (k == count) {
                ans = root.val;
                return;
            }
            dfs(root.right, k);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}