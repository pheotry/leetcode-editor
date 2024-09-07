// 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
// 
// 
// 输入：head = [1,2,2,1]
// 输出：true
// 
//
// 示例 2： 
// 
// 
// 输入：head = [1,2]
// 输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1949 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

/**
 * @Description 回文链表
 * @Date 2024-09-06 11:23:44
 */
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();

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
     * 可以遍历链表把链表存入数组中，然后使用双指针前后遍历数组即可判断。
     * <p>
     * 快慢指针: 空间复杂度O(1) 我们可以反转前或后半部链表，然后看两部分是否一致; 这里我们反转后半部链表；
     * fast = null说明链表长度为偶数，fast.next=null说明链表长度为奇数
     * 反转链表 {@link P206ReverseLinkedList}
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null)
                return true;

            // 快慢指针
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 此时slow指向第一段末尾

            // 反转后半部分
            ListNode secondStart = reverseList(slow.next);

            // 判断是否为回文链表
            while (secondStart != null) {
                if (head.val == secondStart.val) {
                    head = head.next;
                    secondStart = secondStart.next;
                } else
                    return false;
            }
            return true;
        }

        /**
         * 反转链表
         * @param head
         * @return
         */
        private ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;    // 记录一下下一个结点
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}