// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
// 一个节点也可以是它自己的祖先）。”
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// 输出：3
// 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// 输出：5
// 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
// 输入：root = [1,2], p = 1, q = 2
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2802 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 二叉树的最近公共祖先
 * @Date 2024-09-28 23:45:41
 */
public class P236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * 求公共祖先很自然的想到从下到上遍历，后序遍历正好是这个过程。。
     * 1.后序遍历的过程中，如果左子树返回p，右子树返回q，（或者相反）
     * 那么该节点符合题意
     * 2.存在p是q的孩子这种情况，或者相反
     * 也就是位列异侧或同侧
     *
     * 如果在异侧，那么会找到p和q，left，right都不为空；
     * 在同侧的时候，left为空，说明在右侧，否则在左侧，
     * 同侧这种情况搜到一个结点比如p，q为p的子孙结点，这时候搜p的另一边，肯
     * 定搜不到的，但是q一定在，所以一定是p
     *
     * 本题只适用于两个结点都存在的情况
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) return right;
            if (right == null) return left;
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}