// 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
// 输入：root = [1,null,2,2]
// 输出：[2]
// 
//
// 示例 2： 
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
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 771 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉搜索树中的众数
 * @Date 2024-09-28 23:23:01
 */
public class P501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();

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
     * BST：使用一个pre记录上一个结点，统计每个元素的个数，
     * 如果大于最大个数的话，那就清空结果集，等于的话就把当前元素加入结果集.
     * {@link P530MinimumAbsoluteDifferenceInBst} 二叉树的最小绝对差
     * <p>
     * 简单操作的话，那就直接中序遍历一遍，然后再遍历一遍中序序列即可
     */
    class Solution {
        List<Integer> res;
        TreeNode pre;   // 记录上一个元素
        int count, maxCount;    // 当前元素个数和最多元素个数

        public int[] findMode(TreeNode root) {
            pre = null;
            res = new ArrayList<>();
            dfs(root);
            int[] resArray = new int[res.size()];
            for (int i = 0; i < res.size(); i++)
                resArray[i] = res.get(i);
            return resArray;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            if (pre == null)   // 处理第一个元素
                count = 1;
            else if (pre.val == root.val)   // 当前元素和前一个元素相等
                count++;
            else    // 当前元素和前一个不相等
                count = 1;
            if (count == maxCount)  // 当前元素目前最多
                res.add(root.val);
            else if (count > maxCount) {
                res.clear();
                maxCount = count;
                res.add(root.val);
            }
            // 更新pre
            pre = root;
            dfs(root.right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}