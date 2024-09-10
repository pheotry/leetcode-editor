//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
// key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
// 输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// 输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
// 解释
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // 缓存是 {1=1}
// lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
// lRUCache.get(1);    // 返回 1
// lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
// lRUCache.get(2);    // 返回 -1 (未找到)
// lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
// lRUCache.get(1);    // 返回 -1 (未找到)
// lRUCache.get(3);    // 返回 3
// lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3259 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;
import leetcode.editor.cn.base.Node;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description LRU 缓存
 * @Date 2024-09-09 18:37:55
 */
public class P146LruCache {
    public static void main(String[] args) {
    }

// leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 使用语言自带的数据结构
     */
    class LRUCache1 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache1(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    /**
     * 自定义链表结构：
     * 定义双链表
     * get(): 没有返回-1，有的话，删除结点，把该结点添加到头
     * put(): 把该结点添加到头部
     */
    class LRUCache {
        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private Node dummy = null;
        private Map<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dummy = new Node();
            dummy.prev = dummy;
            dummy.next = dummy;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null)
                return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) { // 不存在
                Node newNode = new Node(key, value);
                // 添加到哈希表
                map.put(key, newNode);
                // 添加到链表头部
                addToHead(newNode);
                if (map.size() > capacity) {
                    Node tail = removeTail();
                    map.remove(tail.key);
                }
            } else {
                // key已存在
                node.value = value;
                moveToHead(node);
            }
        }

        private void moveToHead(Node node) {
            // 删除该结点的引用
            removeNode(node);
            // 移动到头部位置
            addToHead(node);
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.prev = dummy;
            node.next = dummy.next;
            dummy.next.prev = node;
            dummy.next = node;
        }

        private Node removeTail() {
            Node tail = dummy.prev;
            dummy.prev = tail.prev;
            tail.prev.next = dummy;
            return tail;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// leetcode submit region end(Prohibit modification and deletion)

}