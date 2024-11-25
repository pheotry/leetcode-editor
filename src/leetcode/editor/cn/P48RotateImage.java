// 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
// 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 1962 👎 0

package leetcode.editor.cn;

/**
 * @Description 旋转图像
 * @Date 2024-11-21 20:54:31
 */
public class P48RotateImage {
    public static void main(String[] args) {
        Solution solution = new P48RotateImage().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 观察矩阵旋转90°后可以发现：
     * 「第 i 行」元素旋转到「第 n−1−i 列」元素；
     * 「第 j 列」元素旋转到「第 j 行」元素；
     * 也就是对于 matrix[i][j] -> matrix[j][n-1-i]
     */
    /**
     * 使用辅助数组：n^2 n^2
     */
    class Solution1 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] tmp = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp[j][n - 1 - i] = matrix[i][j];
                }
            }
            // 再拷贝回来
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = tmp[i][j];
                }
            }
        }
    }

    /**
     * 原地修改 n^2 1
     * <p>
     * 以矩阵四个角 A B C D 为例，经过一轮旋转 D->A, C->D, B->C, A->B,
     * 其中 A 的值在初始被覆盖了，所以需要个临时变量 tmp 提前存储一下。
     * <p>
     * 那么实际上我们只需要枚举左上角1/4的位置进行旋转即可，每次旋转会把其他3部分
     * 一起旋转。分为两种情况：偶数和奇数
     * n为偶数：直接旋转左上角1/4即可
     * n为奇数：中心位置旋转后位置不变，因此只需要旋转 [0,n/2][0,n/2+1]
     */
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            /*
             两个for循环，为什么一个是n/2，另一个是（n+1）/2，前面的
             一个for循环代表行号，后面的一个for循环代表列号，列号取了中间值
             以后会影响行号的中间值。举例说明一下，例如n=4，n/2=2，
             （n+1）/2=2；例如n=5，n/2=2，（n+1）/2=3，首先我们可以
             确定[0][2]坐标中的数据是要改变的，依次改变的坐标是
             [2][4]->[4][2]->[2][0]，观察发现中间一行的数据是会被改变的，
             所以就不需要进行中间一行的改变。
             */
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    int tmp = matrix[i][j]; // 暂存 A
                    matrix[i][j] = matrix[n - 1 - j][i];    // D->A
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // C->D
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // B->C
                    matrix[j][n - 1 - i] = tmp; // A->B
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}