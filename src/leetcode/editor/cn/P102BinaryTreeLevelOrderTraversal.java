// 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[[3],[9,20],[15,7]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 2016 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 二叉树的层序遍历
 * @Date 2024-09-20 11:12:09
 */
public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();

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
     * 层序遍历：需要使用一个辅助队列，每层元素先入队，然后把该层元素放入集合中，把其子节点放入队列中
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null)
                queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                // 这里必须是倒序，否则for (int i = 0; i < queue.size(); i++)，queue.size会一直变化
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                res.add(tmp);
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}