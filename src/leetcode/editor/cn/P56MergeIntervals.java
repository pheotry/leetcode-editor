// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
// 回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
// 
//
// 示例 1： 
//
// 
// 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出：[[1,6],[8,10],[15,18]]
// 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
// 输入：intervals = [[1,4],[4,5]]
// 输出：[[1,5]]
// 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2457 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 合并区间
 * @Date 2024-11-15 11:12:55
 */
public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 对左端点排序，然后逐个合并区间：升序
     * 使用merged保存合并后的数组，如果merged的最后一个元素右端点<当前元素左端点，
     * 说明不重合，当前元素可以加入merged; 其他情况更新merged最大右端点即可：
     * cur.L-merger.R 重合，说明连续，如果cur.R也重合，右端点为merged.R，
     * 否则为cur.R
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, ((o1, o2) ->
                    o1[0] - o2[0]));

            // 保存合并后的结果
            List<int[]> merged = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                // 左右边界
                int L = intervals[i][0];
                int R = intervals[i][1];

                // 列表为空或者跟当前区间不重合
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L)
                    merged.add(new int[]{L, R});
                else // 重合: 修改列表中的右端点为最远坐标
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }

            return merged.toArray(new int[merged.size()][]);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}