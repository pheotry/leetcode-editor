// 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"SEE"
// 输出：true
// 
//
// 示例 3： 
// 
// 
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCB"
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1888 👎 0

package leetcode.editor.cn;

/**
 * @Description 单词搜索
 * @Date 2024-10-17 22:54:37
 */
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 从棋盘的每个位置开始递归搜索单词，如果找到单词末尾说明找到了单词
     * 这里使用了棋盘记录已经访问过的字符，可以节省空间
     */
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (backtracking(board, word, i, j, 0))
                        return true;
                }
            }
            return false;
        }

        /**
         * 向四个方向递归搜索
         *
         * @param board 棋盘
         * @param word  单词
         * @param row   棋盘位置
         * @param col
         * @param index 单词位置
         * @return
         */
        private boolean backtracking(char[][] board, String word, int row, int col, int index) {
            // 棋盘下标越界或者字符不相等，直接剪枝
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index))
                return false;
            // 搜到单词末尾说明搜到了
            if (index == word.length() - 1)
                return true;

            // 选择当前字符
            board[row][col] = '\0';
            // 然后往四个方向递归
            boolean res = backtracking(board, word, row - 1, col, index + 1) ||
                    backtracking(board, word, row + 1, col, index + 1) ||
                    backtracking(board, word, row, col - 1, index + 1) ||
                    backtracking(board, word, row, col + 1, index + 1);
            // 回溯
            board[row][col] = word.charAt(index);

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}