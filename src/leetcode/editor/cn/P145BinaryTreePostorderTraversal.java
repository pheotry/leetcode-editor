// 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
// 
//
// 示例 1： 
//
// 
// 输入：root = [1,null,2,3] 
// 
//
// 输出：[3,2,1] 
//
// 解释： 
//
// 
//
// 示例 2： 
//
// 
// 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9] 
// 
//
// 输出：[4,6,7,5,2,9,8,3,1] 
//
// 解释： 
//
// 
//
// 示例 3： 
//
// 
// 输入：root = [] 
// 
//
// 输出：[] 
//
// 示例 4： 
//
// 
// 输入：root = [1] 
// 
//
// 输出：[1] 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1196 👎 0

package leetcode.editor.cn;

import com.sun.source.tree.Tree;
import leetcode.editor.cn.base.TreeNode;

import java.util.*;

/**
 * @Description 二叉树的后序遍历
 * @Date 2024-09-19 23:06:15
 */
public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        TreeNode root = TreeNode.buildTree(list);
        List<Integer> res = solution.postorderTraversal(root);
        System.out.println(res);
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
     * 递归法
     */
    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postorder(root, res);
            return res;
        }

        private void postorder(TreeNode root, List<Integer> res) {
            if (root == null)
                return;
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }

    /**
     * 迭代法:
     * 中序遍历中，从栈中弹出的节点，其左子树是访问完了，可以直接访问该节点，然后接下来访问右子树。
     * 后序遍历中，从栈中弹出的节点，我们只能确定其左子树肯定访问完了，但是无法确定右子树是否访问过。
     * 因此，我们在后序遍历中，引入了一个prev来记录历史访问记录。
     * 当访问完一棵子树的时候，我们用prev指向该节点。
     * 这样，在回溯到父节点的时候，我们可以依据prev是指向左子节点，还是右子节点，来判断父节点的访问情况。
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode node = root;
            TreeNode prev = null;   // 用来记录上一个访问的结点
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();

                // 没有右子树或者右子树已经访问过了，说明当前结点可以访问
                if (node.right == null || prev == node.right) {
                    res.add(node.val);
                    prev = node;
                    node = null;
                } else {    // 右子树还没访问，当前结点入栈，访问右子树
                    stack.push(node);
                    node = node.right;
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}