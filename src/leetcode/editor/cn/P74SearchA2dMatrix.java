// 给你一个满足下述两条属性的 m x n 整数矩阵：
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 966 👎 0

package leetcode.editor.cn;

/**
 * @Description 搜索二维矩阵
 * @Date 2024-09-10 13:19:53
 */
public class P74SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        int[][] m = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        solution.searchMatrix(m, 13);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分查找：在每一行上进行二分查找
     * 优化：目前是遍历最后一列找到元素所在行再二分查找，实际上可以直接在列上二分查找找到对应的行，然后在行上二分查找找到位置；
     * 或者直接把二维数组看作一维数组，进行一次二分查找即可，初始left=0,right=m*n-1
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
                if (target > matrix[i][n - 1])
                    continue;
                int left = 0, right = n - 1;
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (matrix[i][mid] == target)
                        return true;
                    else if (matrix[i][mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                return false;
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}