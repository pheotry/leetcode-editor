// 给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
// 输出：[1,1,2,3,4,4,5,6]
// 解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
// 将它们合并到一个有序链表中得到。
// 1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
// 输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
// 输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2876 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

import java.util.PriorityQueue;

/**
 * @Description 合并 K 个升序链表
 * @Date 2024-09-09 17:58:24
 */
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();

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
     * 小顶堆：Onlogk k
     * 把k个链表的头结点入堆，弹出堆顶元素，然后把堆顶元素的对应链表的下一个元素入堆，弹出元素为最小元素，
     * 加入新链表，重复此操作，直到堆内为空
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;

            PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            for (ListNode head : lists) {
                if (head != null)
                    heap.offer(head);
            }

            while (!heap.isEmpty()) {
                ListNode node = heap.poll();
                if (node.next != null)
                    heap.offer(node.next);
                cur.next = node;
                cur = cur.next;
            }

            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}