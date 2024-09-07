// 给你一个链表的头节点 head ，判断链表中是否有环。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
// 链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：head = [3,2,0,-4], pos = 1
// 输出：true
// 解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
// 输入：head = [1,2], pos = 0
// 输出：true
// 解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
// 输入：head = [1], pos = -1
// 输出：false
// 解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// Related Topics 哈希表 链表 双指针 👍 2193 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 环形链表
 * @Date 2024-09-06 23:02:04
 */
public class P141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new P141LinkedListCycle().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    /**
     * 哈希表：遍历链表存入set，如果已存在说明有环，否则无环
     */
    class Solution1 {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head))
                    return true;
                set.add(head);
                head = head.next;
            }
            return false;
        }
    }

    /**
     * 快慢指针
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null)
                return false;

            // 快慢指针错开了，这是因为我们的循环条件为slow != fast，如果相等可以使用do while循环
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null)
                    return false;
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}