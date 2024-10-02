// 给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,2,5,3,4,null,6]
// 输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
// 输入：root = []
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：root = [0]
// 输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1735 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

/**
 * @Description 二叉树展开为链表
 * @Date 2024-09-30 14:16:50
 */
public class P114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();

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
     * 展开顺序为先序遍历的顺序，一个简单的做法为先序遍历一遍然后记录所有节点，然后把所有节点串起来即可
     * <p>
     * 迭代法：对于当前节点，如果左节点不为空，那么把右节点连接到其左子树的最右边，再把左子树移动到右子树，左子树置null\
     * 递归法先序遍历的话可以使用一个辅助栈先保存一下右节点，入栈顺序为右左
     */
    class Solution {
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode next = cur.left;
                    // 找左子树最右边的节点
                    TreeNode predecessor = next;
                    while (predecessor.right != null)
                        predecessor = predecessor.right;
                    // 右子树接到前驱节点
                    predecessor.right = cur.right;
                    // 左子树移动到右节点的位置
                    cur.right = next;
                    cur.left = null;
                }
                cur = cur.right;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}