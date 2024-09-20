package leetcode.editor.cn.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 通过列表创建二叉树
     * @param nodes
     * @return
     */
    public static TreeNode buildTree(List<Integer> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nodes.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int idx = 1;
        while (!queue.isEmpty() && idx < nodes.size()) {
            TreeNode currentNode = queue.poll();

            // Create the left child and add it to the queue.
            if (idx < nodes.size() && nodes.get(idx) != null) {
                currentNode.left = new TreeNode(nodes.get(idx));
                queue.add(currentNode.left);
            }
            idx++;

            // Create the right child and add it to the queue.
            if (idx < nodes.size() && nodes.get(idx) != null) {
                currentNode.right = new TreeNode(nodes.get(idx));
                queue.add(currentNode.right);
            }
            idx++;
        }
        return root;
    }
}
