// 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
// 
// 
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1794 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 螺旋矩阵
 * @Date 2024-11-21 12:15:18
 */
public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 模拟：mn 1
     * 矩阵长宽不一样，要提前判定边界
     */
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> res = new ArrayList<>();

            int left = 0, right = n - 1;
            int top = 0, button = m - 1;

            while (true) {
                for (int i = left; i <= right; i++)
                    res.add(matrix[top][i]);
                if (++top > button)
                    break;

                for (int i = top; i <= button; i++)
                    res.add(matrix[i][right]);
                if (--right < left)
                    break;

                for (int i = right; i >= left; i--)
                    res.add(matrix[button][i]);
                if (--button < top)
                    break;

                for (int i = button; i >= top; i--)
                    res.add(matrix[i][left]);
                if (++left > right)
                    break;
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}