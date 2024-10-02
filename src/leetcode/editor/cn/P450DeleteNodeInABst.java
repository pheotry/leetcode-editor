// 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
// 根节点的引用。
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
// 输入：root = [5,3,6,2,4,null,7], key = 3
// 输出：[5,4,6,2,null,null,7]
// 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
// 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
// 另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
// 输入: root = [5,3,6,2,4,null,7], key = 0
// 输出: [5,3,6,2,4,null,7]
// 解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
// 输入: root = [], key = 0
// 输出: []
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics 树 二叉搜索树 二叉树 👍 1374 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.Currency;
import java.util.logging.Level;

/**
 * @Description 删除二叉搜索树中的节点
 * @Date 2024-09-29 11:07:10
 */
public class P450DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new P450DeleteNodeInABst().new Solution();

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
     * 迭代法
     * 1.没找到，直接返回
     * 2.删除结点是叶结点，直接删除
     * 3.删除结点有一个孩子，孩子补位
     * 4.删除结点有两个孩子，使用直接前驱后直接后继部位，此时转化为2，3的情况
     */
    class Solution1 {
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode cur = root, parent = null;
            // 寻找要删除的结点
            while (cur != null && cur.val != key) {
                parent = cur;
                if (key < cur.val)
                    cur = cur.left;
                else
                    cur = cur.right;
            }
            if (cur == null)    // 未找到
                return root;
            if (cur.left != null && cur.right != null) { // 两个孩子
                TreeNode successor = cur.right; // 这里找直接后继
                TreeNode successorParent = cur;
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                // 替换cur
                cur.val = successor.val;
                // 转换为删除叶结点或一个孩子的结点
                cur = successor;
                parent = successorParent;
            }
            // 删除叶节点或单个孩子结点
            TreeNode child = cur.left == null ? cur.right : cur.left;

            if (parent == null) // 删除的是根节点
                root = child;
            else if (parent.left == cur)
                parent.left = child;
            else
                parent.right = child;

            return root;
        }
    }

    /**
     * 递归法
     */
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return root;  // 没找到
            if (root.val == key) {
                // 把一个孩子结点和叶节点统一起来了
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;

                // 两个孩子结点: 这里用 直接后继
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                // 删除直接后继
                root.right = deleteNode(root.right, successor.val);
                successor.right = root.right;
                successor.left = root.left;
                return successor;
            }
            // 待删除结点位于左子树或右子树，递归删除，注: 要修改root指针指向
            if (root.val > key) root.left = deleteNode(root.left, key);
            if (root.val < key) root.right = deleteNode(root.right, key);
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}