// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
// 
// 
// 输入：head = [1,2,3,4,5], n = 2
// 输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
// 输入：head = [1], n = 1
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：head = [1,2], n = 1
// 输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2928 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 删除链表的倒数第 N 个结点
 * @Date 2024-09-07 18:46:39
 */
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

    /**
     * 添加一个虚拟头节点：把删除表头和其他位置统一起来；
     * 要获取到删除节点前驱结点
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode slow = dummy, fast = dummy;
            // 快指针先走n步
            while (n-- >= 0)
                fast = fast.next;

            // 快慢指针一起走
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;

            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}