////给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
////
//// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连
// 接到
////链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
////
//// 不允许修改 链表。 
////
//// 
//// 
////
//// 
////
//// 示例 1： 
////
//// 
////
//// 
////输入：head = [3,2,0,-4], pos = 1
////输出：返回索引为 1 的链表节点
////解释：链表中有一个环，其尾部连接到第二个节点。
//// 
////
//// 示例 2： 
////
//// 
////
//// 
////输入：head = [1,2], pos = 0
////输出：返回索引为 0 的链表节点
////解释：链表中有一个环，其尾部连接到第一个节点。
//// 
////
//// 示例 3： 
////
//// 
////
//// 
////输入：head = [1], pos = -1
////输出：返回 null
////解释：链表中没有环。
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 链表中节点的数目范围在范围 [0, 10⁴] 内 
//// -10⁵ <= Node.val <= 10⁵ 
//// pos 的值为 -1 或者链表中的一个有效索引 
//// 
////
//// 
////
//// 进阶：你是否可以使用 O(1) 空间解决此题？ 
////
//// Related Topics 哈希表 链表 双指针 👍 2604 👎 0
//

package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

/**
 * @Description 环形链表 II
 * @Date 2024-09-06 23:22:00
 */
public class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();

    }

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

    /**
     * 快慢指针: 无环部分x, 有环部分 y+z，相遇时：slow走 x+y, fast 走 x+y+n(y+z),走了n圈追上slow， fast走slow 2倍；
     * x+y+n(y+z)=2(x+y) => ny+nz-y=x => (n-1)(y+z)+z=x => y+z为环长，z处为相遇点（交点到相遇长度为b，相遇到交点长度为z）。
     * 也就是说在相遇处走n-1圈，再到交点的距离为从起点到交点的距离。
     * 所以相遇时我们可以直接使用另一个指针从起点开始和slow同步移动，他们相遇时即为交点。
     * <p>
     * 角度2：无环部分a，有环部分长度为b，相遇时：slow走s，fast走f=2s，fast比slow多走了n圈追上了slow，f=s+nb => f=2nb,s=nb;
     * 从头开始走，如果要走到环起点，需要走 k=a+nb,如何控制走a步呢？使用双指针，相遇时slow已经走了nb步，它和起点出发的指针同时走a步
     * 就会在环入口相遇
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    while (slow != head) {
                        slow = slow.next;
                        head = head.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}