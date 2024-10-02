//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
// 
// 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 1094 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 另一棵树的子树
 * @Date 2024-09-26 10:39:28
 */
public class P572SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new P572SubtreeOfAnotherTree().new Solution();

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
     * {@link P100SameTree}
     * {@link P101SymmetricTree}
     * <p>
     * 直接先序遍历树，判断每个结点开始和子树是否一致，问题转化为 SameTree
     */
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null)
                return false;

            return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null || p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    /**
     * 求两个数的先序序列，那么问题转化为求模式串的位置，
     * 即 KMP 算法
     */
    class Solution1 {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
                return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}