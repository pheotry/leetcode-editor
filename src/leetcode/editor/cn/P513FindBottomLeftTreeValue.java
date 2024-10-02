// 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
// 输入: root = [2,1,3]
// 输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
// 输入: [1,2,3,4,null,5,6,null,null,7]
// 输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 594 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 找树左下角的值
 * @Date 2024-09-26 18:05:15
 */
public class P513FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new P513FindBottomLeftTreeValue().new Solution();

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
     * BFS，从右往左遍历
     * 最底层最左边的值实际就是最后一个节点
     * 如果是正常顺序遍历，那就是记录最后一层的第一个元素即可
     */
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            int res = 0;
            if (root != null) queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
                res = node.val;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}