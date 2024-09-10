// 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
// 输入：head = [4,2,1,3]
// 输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
// 输入：head = [-1,5,3,4,0]
// 输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
// 输入：head = []
// 输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2365 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

/**
 * @Description 排序链表
 * @Date 2024-09-08 20:53:00
 */
public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
        ListNode dummy = new ListNode(), cur = dummy;
        for (int i : new int[]{4, 2, 1, 3}) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }

        solution.sortList(dummy.next);
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
     * 自顶向下递归：Onlogn Ologn: 归并排序空间复杂度为 On，其中开辟数组空间On，递归Ologn，链表无需开辟新的数组空间
     * 分割+合并：使用快慢指针找到中点，把链表分为两部分，对两部分递归排序，然后合并这两部分
     * <p>
     * 合并有序链表 {@link P21MergeTwoSortedLists}
     */
    class Solution1 {
        public ListNode sortList(ListNode head) {
            // 递归终止条件
            if (head == null || head.next == null)
                return head;

            // 快慢指针：奇数结点slow指向中间结点（右边多个结点），偶数结点slow指向中间左边结点
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 链表中间断开，分为两部分
            ListNode tmp = slow.next;
            slow.next = null;

            // 递归排序两部分链表
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);

            // 合并left和right两部分链表
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            // 合并两部分长度不一致的部分
            cur.next = left != null ? left : right;

            return dummy.next;
        }
    }

    /**
     * 自底向上迭代：归并排序 Onlog O1
     * subLenth=1为初始子链表长度，我们依次两两合并子链表，然后把subLength翻倍*2，重复这一合并过程，直到subLength=原始链表
     * 长度，代表排序完成
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            // 统计链表长度
            int length = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                length++;
            }

            ListNode dummy = new ListNode(0, head);
            for (int subLen = 1; subLen < length; subLen = subLen << 1) {
                ListNode pre = dummy;   // 记录合并前的两端链表前一个结点
                cur = dummy.next;

                while (cur != null) {
                    // 分割出两部分链表
                    ListNode left = cur;
                    for (int i = 1; i < subLen && cur.next != null; i++)    // 分割出第一段
                        cur = cur.next;

                    ListNode right = cur.next;
                    cur.next = null;    // 断开第一段
                    cur = right;
                    for (int i = 1; i < subLen && cur != null && cur.next != null; i++) // 分割第二段
                        cur = cur.next;

                    ListNode next = null;   // 下一段的开头
                    if (cur != null) {
                        next = cur.next;
                        cur.next = null;    // 断开第二段
                    }

                    // 合并两段
                    ListNode merged = mergeTwoSortedLists(left, right);
                    pre.next = merged;  // 拼接前面
                    // 拼接后面
                    while (pre.next != null)
                        pre = pre.next;

                    cur = next; // 更新cur位置到下一段开头
                }
            }
            return dummy.next;
        }

        /**
         * 合并链表并返回合并后的头结点
         *
         * @param left
         * @param right
         * @return 合并后的头结点
         */
        private ListNode mergeTwoSortedLists(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            cur.next = left != null ? left : right;

            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}