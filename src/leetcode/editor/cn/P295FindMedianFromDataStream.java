// 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
//
// 
// 例如 arr = [2,3,4] 的中位数是 3 。 
// 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。 
// 
//
// 实现 MedianFinder 类: 
//
// 
// MedianFinder() 初始化 MedianFinder 对象。 
// void addNum(int num) 将数据流中的整数 num 添加到数据结构中。 
// double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。 
// 
//
// 示例 1： 
//
// 
// 输入
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
// 输出
//[null, null, null, 1.5, null, 2.0]
//
// 解释
// MedianFinder medianFinder = new MedianFinder();
// medianFinder.addNum(1);    // arr = [1]
// medianFinder.addNum(2);    // arr = [1, 2]
// medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
// medianFinder.addNum(3);    // arr[1, 2, 3]
// medianFinder.findMedian(); // return 2.0
//
// 提示: 
//
// 
// -10⁵ <= num <= 10⁵ 
// 在调用 findMedian 之前，数据结构中至少有一个元素 
// 最多 5 * 10⁴ 次调用 addNum 和 findMedian 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 1040 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @Description 数据流的中位数
 * @Date 2024-09-19 12:32:53
 */
public class P295FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new P295FindMedianFromDataStream().new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.findMedian();
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 中位数为有序序列中间值或是中间两个值的平均值：那么我们可以使用两个优秀队列来找到他们：
     * 分别使用 大顶堆和小顶堆 来保存 小于或等于中位数和大于中位数 的和：如果两个堆数量相同，那中位数为堆顶元素平均值，
     * 否则为 大顶堆的堆顶元素。
     * 对于新加入的num:
     * 1.当前两个堆大小不相等(大顶堆queMax多一个元素):把num放到queMax过滤一下然后把堆顶元素放到queMin
     * 2.当前堆大小相等, 把num放到queMin过滤一下,把堆顶元素放到queMax
     *
     * 这里不需要比较插入的num和堆顶元素是因为直接通过两个堆的大小来比较选择插入位置的,插入后再把堆顶元素放到另一个堆来
     * 平衡两个堆的大小,始终保持左边大根堆>=右边小根堆的个数.
     * 如果比较的话,那么比较num和左边大根堆的堆顶元素,如果num<=堆顶元素的话,那要插入,然后根据两个堆的大小选择是否要把
     * 堆顶元素移动到右边小根堆,否则插入到右边小根堆,然后判断是否要平衡堆.
     *
     * 左大根堆右小根堆,小加左,大加右,堆平衡
     */
    class MedianFinder {
        private PriorityQueue<Integer> queMax, queMin;

        public MedianFinder() {
            queMax = new PriorityQueue<>((a, b) -> (b - a));    // 大顶堆
            queMin = new PriorityQueue<>(); // 小顶堆
        }

        public void addNum(int num) {
            if (queMax.size() != queMin.size()) {
                queMax.offer(num);
                queMin.offer(queMax.poll());
            } else {
                queMin.offer(num);
                queMax.offer(queMin.poll());
            }
        }

        public double findMedian() {
            // 两个堆大小一样就返回堆顶元素平均值,否则反对大顶堆堆顶元素(实际就是比较多的那个堆的堆顶元素)
            return queMax.size() != queMin.size() ? queMax.peek() : (queMax.peek() + queMin.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// leetcode submit region end(Prohibit modification and deletion)

}