// 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 
//
// 示例 1: 
//
// 
//
// 
// 输入: [1,2,3,null,5,null,4]
// 输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
// 输入: [1,null,3]
// 输出: [1,3]
// 
//
// 示例 3: 
//
// 
// 输入: []
// 输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1117 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 二叉树的右视图
 * @Date 2024-09-20 12:17:20
 */
public class P199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();

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
     * 二叉树的右视图就是每层最后一个结点，使用层序遍历即可
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> res = new ArrayList<>();
            if (root != null)
                queue.offer(root);
            while (!queue.isEmpty()) {
                // 处理每一层
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (i == 1) // 说明是本层最后一个结点
                        res.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}