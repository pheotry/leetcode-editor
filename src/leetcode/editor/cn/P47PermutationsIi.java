// 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,1,2]
// 输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3]
// 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1617 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 全排列 II
 * @Date 2024-10-13 19:19:30
 */
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * {@link P46Permutations}
     * 这里允许元素重复: 所以要对结果去重
     * 对数组要进行排序
     */
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[nums.length];

            Arrays.sort(nums);

            backtracking(nums, used, path, res);
            return res;
        }

        private void backtracking(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // used[i]=true 说明同一树枝nums[i]使用过
                // used[i]=false 说明同一树枝nums[i]使用过
                // 如果本层使用过nums[i-1]，且nums[i-1]=nums[i]，那么直接跳过
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
                    continue;

                if (!used[i]) {
                    used[i] = true;
                    path.add(nums[i]);

                    backtracking(nums, used, path, res);

                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}