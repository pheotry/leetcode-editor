// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [0,1,0,3,12]
// 输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
// 输入: nums = [0]
// 输出: [0]
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2479 👎 0

package leetcode.editor.cn;

/**
 * @Description 移动零
 * @Date 2024-11-01 11:30:58
 */
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 双指针：右指针指向不为0的元素，然后把它交换到左边
     * 左指针为非0元素，相当于交换自身了，左指针指向0元素，则互相交换
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] != 0) {
                    int tmp = nums[right];
                    nums[right] = nums[left];
                    nums[left++] = tmp;
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}