// 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
// 返回这颗 二叉树 。
//
// 
//
// 示例 1: 
// 
// 
// 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// 输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
// 输入：inorder = [-1], postorder = [-1]
// 输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1267 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 从中序与后序遍历序列构造二叉树
 * @Date 2024-09-27 11:59:47
 */
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        solution.buildTree(inorder, postorder);
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
     * 中序遍历：根左右
     * 后序遍历：左右根
     * 通过中序和后序还原二叉树：选择后序最后一个元素作为根结点，找到它在中序中对应的位置，则左边为二叉树左子树部分，右边
     * 为二叉树右子树，继续在左右子树上通过后序和中序数组进行划分
     * <p>
     * 使用map缓存一下中序数组，方便快速定位到元素在中序数组中的位置
     */
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int len = postorder.length;
            // 将中序数组使用map存一下，方便快速定位
            Map<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < len; i++)
                index.put(inorder[i], i);

            // 左闭右开区间
            return dfs(inorder, 0, len, postorder, 0, len, index);
        }

        /**
         * 通过中序和后序构造二叉树
         * 左闭右开
         *
         * @param inorder   中序数组
         * @param inL
         * @param inR
         * @param postorder 后序数组
         * @param postL
         * @param postR
         * @param index
         * @return
         */
        private TreeNode dfs(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR, Map<Integer, Integer> index) {
            if (postL == postR) // 空节点
                return null;
            int leftSize = index.get(postorder[postR - 1]) - inL;
            TreeNode left = dfs(inorder, inL, inL + leftSize, postorder, postL, postL + leftSize, index);
            TreeNode right = dfs(inorder, inL + leftSize + 1, inR, postorder, postL + leftSize, postR - 1, index);
            return new TreeNode(postorder[postR - 1], left, right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}