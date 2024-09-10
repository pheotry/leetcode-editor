// 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：head = [1,2,3,4,5], k = 2
// 输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
// 输入：head = [1,2,3,4,5], k = 3
// 输出：[3,2,1,4,5]
// 
//
// 
// 提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2391 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

/**
 * @Description K 个一组翻转链表
 * @Date 2024-09-07 22:52:58
 */
public class P25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
        // solution.reverseList(dummy.next, cur);
        // ListNode t = dummy.next;
        // for (int i = 0; i < 5; i++) {
        //     System.out.println(t.val);
        //     t = t.next;
        // }
        cur = dummy;
        for (int i = 0; i < 5; i++) {
            cur = cur.next;
            System.out.print(cur.val + " ");
        }
        System.out.println();
        ListNode node = solution.reverseKGroup(dummy.next, 2);
        cur = node;
        for (int i = 0; i < 5; i++) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /**
     * 反转链表 {@link P206ReverseLinkedList}
     * 如果长度为k，就反转这k个结点，反转后需要和原来的链表连接起来，使用pre记录上一段最后一个结点，
     * 加入哨兵结点，把第一段和其他段的处理统一起来。
     * 本段反转后第一个结点成为了最后一个结点，连接到下一段（反转后可以返回这个结点，也可以反转的时候，
     * 先记录到下一段的第一个结点，左闭右开）
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = dummy;   // 始终指向上一段的最后一个结点
            while (head != null) {
                ListNode tail = pre;    // 指向本段的最后一个结点
                for (int i = 0; i < k; i++) {
                    tail = tail.next;
                    if (tail == null)
                        return dummy.next;  // 长度不足k了就返回修改后的链表
                }

                ListNode nextStart = tail.next; // 下一段的开头结点
                ListNode[] nodes = reverseList(head, tail);

                // 连接一下链表
                pre.next = nodes[0];    // 连接前一段和反转后的本段
                pre = nodes[1];   // 连接本段和后一段
                pre.next = nextStart;

                head = nextStart;   // 更新一下head位置
            }
            return dummy.next;
        }

        /**
         * 反转head-tail部分的链表
         *
         * @param head // 开头
         * @param tail // 结尾
         * @return ListNode[] 返回反转后的开头和结尾结点
         */
        private ListNode[] reverseList(ListNode head, ListNode tail) {
            ListNode pre = null;
            ListNode cur = head;
            while (pre != tail) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return new ListNode[]{pre, head};
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}