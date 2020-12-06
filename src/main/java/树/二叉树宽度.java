package 树;

import type.TreeNode;
import type.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树宽度 {
    public static int getTreeWidth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(head);
        int max = 0;
        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                max = getMax(q1, q2, max);
            }
            while (!q2.isEmpty()) {
                max = getMax(q2, q1, max);
            }
        }
        return max;
    }

    private static int getMax(Queue<TreeNode> q1, Queue<TreeNode> q2, int max) {
        max = Math.max(max, q1.size());
        TreeNode node = q1.remove();
        if (node.left != null) q2.add(node.left);
        if (node.right != null) q2.add(node.right);
        return max;
    }

    public static void main(String[] args) {
        TreeNode head = TreeUtils.defaultTree();
        System.out.println(getTreeWidth(head));
    }
}
