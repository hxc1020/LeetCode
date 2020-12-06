package 树;

import type.Pair;
import type.TreeNode;
import type.TreeUtils;

public class 二叉树平衡性 {
    public static boolean isBalance(TreeNode head) {
        return check(head).first;
    }

    private static Pair<Boolean, Integer> check(TreeNode node) {
        if (node == null) {
            return Pair.of(true, 0);
        }
        Pair<Boolean, Integer> left = check(node.left);
        Pair<Boolean, Integer> right = check(node.right);
        boolean isBalance = left.first && right.first && Math.abs(left.second - right.second) <= 1;
        return Pair.of(isBalance, Math.max(left.second, right.second) + 1);
    }

    public static void main(String[] args) {
        TreeNode head = TreeUtils.defaultTree();
//        head.left.left.left = new TreeNode(1);
//        head.left.left.left.left = new TreeNode(1);
        System.out.println(isBalance(head));
    }
}
