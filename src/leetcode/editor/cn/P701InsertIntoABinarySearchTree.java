// 给定二叉搜索树（BST）的根节点
// root 和要插入树中的值
// value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。 
//
// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [4,2,7,1,3], val = 5
// 输出：[4,2,7,1,3,5]
// 解释：另一个满足题目要求可以通过的树是：
//
// 
//
// 示例 2： 
//
// 
// 输入：root = [40,20,60,10,30,50,70], val = 25
// 输出：[40,20,60,10,30,50,70,null,null,25]
// 
//
// 示例 3： 
//
// 
// 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
// 输出：[4,2,7,1,3,5]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数将在
// [0, 10⁴]的范围内。
// 
// -10⁸ <= Node.val <= 10⁸ 
// 所有值 
// Node.val 是 独一无二 的。 
// -10⁸ <= val <= 10⁸ 
// 保证 val 在原始BST中不存在。 
// 
//
// Related Topics 树 二叉搜索树 二叉树 👍 583 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 二叉搜索树中的插入操作
 * @Date 2024-09-29 10:53:31
 */
public class P701InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P701InsertIntoABinarySearchTree().new Solution();

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
     * DFS：递归函数有返回值可以实现父结点和新加入结点的关系连接；
     * 如果没有返回值的话，那么要记录一下父节点，在找到插入位置的时候可以插入
     */
    class Solution1 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (val < root.val)
                root.left = insertIntoBST(root.left, val);
            else
                root.right = insertIntoBST(root.right, val);
            return root;
        }
    }

    /**
     * 迭代法：要记录一下父节点
     */
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            TreeNode cur = root;
            TreeNode parent = root;

            while (cur != null) {
                parent = cur;
                if (val < cur.val) cur = cur.left;
                else cur = cur.right;
            }

            TreeNode node = new TreeNode(val);
            if (parent.val > val)
                parent.left = node;
            else
                parent.right = node;
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}