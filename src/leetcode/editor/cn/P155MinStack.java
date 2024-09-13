// 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
// 输出：
//[null,null,null,null,-3,null,0,-2]
//
// 解释：
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
//
// Related Topics 栈 设计 👍 1815 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 最小栈
 * @Date 2024-09-13 13:05:52
 */
public class P155MinStack {
    public static void main(String[] args) {
        MinStack m = new P155MinStack().new MinStack();
        m.push(0);
        m.push(1);
        m.push(0);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 使用一个辅助栈 minStack 记录最小元素
     * push: 当前元素小于等于minStack栈顶元素时，入栈，更新最小元素，否则只入主栈stack即可
     * pop：如果stack栈顶元素是最小元素，要把minStack栈顶元素也弹出
     */
    class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int val) {
            if (minStack.isEmpty() || val <= minStack.peek())
                minStack.push(val);
            stack.push(val);
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek()))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// leetcode submit region end(Prohibit modification and deletion)

}