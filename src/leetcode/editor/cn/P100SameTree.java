// 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：p = [1,2,3], q = [1,2,3]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：p = [1,2], q = [1,null,2]
// 输出：false
// 
//
// 示例 3： 
// 
// 
// 输入：p = [1,2,1], q = [1,1,2]
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1175 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 相同的树
 * @Date 2024-09-26 10:20:59
 */
public class P100SameTree {
    public static void main(String[] args) {
        Solution solution = new P100SameTree().new Solution();

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
     * {@link P101SymmetricTree} 对称二叉树
     *
     * 对于任何两个对称结点：p，q
     * p.val=q.val，此结点对称
     * p.left.val=q.left.val
     * p.right.val=q.right.val
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if (p == null || q == null || p.val != q.val)
                return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}