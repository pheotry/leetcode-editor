// 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
// 输入：root = [1,2,3,null,5]
// 输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
// 输入：root = [1]
// 输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1165 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉树的所有路径
 * @Date 2024-09-25 23:38:58
 */
public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();

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
     * DFS：这道题需要记录路径，适合先序遍历，遇到叶子结点就记录当前路径，
     * 并回溯。
     * 注：这里路径使用的String记录，如果用StringBuilder之类的记录的话，每次要new
     * 一个新的传进去
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            dfs(root, "", res);
            return res;
        }

        private void dfs(TreeNode root, String path, List<String> res) {
            if (root == null)
                return;
            // 遇到叶子结点，此时需要输出这段路径
            if (root.left == null && root.right == null) {
                res.add(path + root.val);
                return;
            }
            String tmp = path + root.val + "->";
            dfs(root.left, tmp, res);
            dfs(root.right, tmp, res);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}