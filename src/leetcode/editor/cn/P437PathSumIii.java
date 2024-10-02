// 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// 输出：3
// 解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
// 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// 输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1921 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 路径总和 III
 * @Date 2024-09-30 22:25:03
 */
public class P437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new P437PathSumIii().new Solution();

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
     * {@link P560SubarraySumEqualsK 和为K的子数组}
     * 前缀和+map
     * 从根到一个叶子节点可以看作是一个数组，需要求的就是子数组的和为target，
     * 对应于二叉树和为target的路径，这个问题很适合 前缀和
     */
    class Solution {
        private Map<Long, Integer> map = new HashMap<>();   // 记录当前路径的前缀和和次数

        public int pathSum(TreeNode root, int targetSum) {
            map.put(0L, 1);
            return dfs(root, targetSum, 0);
        }

        /**
         * 先序遍历：返回到达当前节点及其子节点可以得到满足条件的路径
         *
         * @param root      当前节点
         * @param targetSum
         * @param preSum    从根节点到当前节点的路径
         * @return 以当前节点为最后一个节点的路径, 符合条件的路径数
         */
        private int dfs(TreeNode root, int targetSum, long preSum) {
            if (root == null) return 0; // 空节点，满足条件的路径为0
            preSum += root.val; // 更新前缀和
            int pathCnt = map.getOrDefault(preSum - targetSum, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            pathCnt = pathCnt + dfs(root.left, targetSum, preSum) + dfs(root.right, targetSum, preSum);
            map.put(preSum, map.get(preSum) - 1);   // 回溯
            return pathCnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}