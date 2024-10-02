// 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
// 一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// 输出: 6
// 解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// 输出: 2
// 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1277 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 二叉搜索树的最近公共祖先
 * @Date 2024-09-29 00:16:34
 */
public class P235LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P235LowestCommonAncestorOfABinarySearchTree().new Solution();

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
     * {@link P236LowestCommonAncestorOfABinaryTree} 二叉树得到最近公共祖先
     * 迭代法: 利用二叉搜索树的特性，从上到下遍历二叉搜索树，如果当前结点大于p和q，，说明
     * p，q在当前结点的左侧，向左遍历即可，遇到第一个落在[p,q]范围内的结点即为
     * 我们需要的最近公共祖先
     *
     * 怎么确定当前找到的结点为分岔点点呢？反证法：如果两个结点位于同侧，那么要移动指针，
     * 位于分岔点后，如果此时再移动指针，便不满足当前结点位于[p,q]之间了
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if ((root.val > p.val && root.val > q.val))
                    root = root.left;
                else if (root.val < p.val && root.val < q.val)
                    root = root.right;
                else
                    return root;
            }
            return null;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}