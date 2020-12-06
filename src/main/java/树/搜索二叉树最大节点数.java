package 树;

import type.FindSearchTreeCount;
import type.TreeNode;

public class 搜索二叉树最大节点数 {
    public static int maxSearchTreeCount(TreeNode head) {
        return 0;
    }

    public static FindSearchTreeCount find(TreeNode x) {
        if (x == null) {
            return null;
        }
        FindSearchTreeCount left = find(x.left);
        FindSearchTreeCount right = find(x.right);
        int max = x.val;
        int min = x.val;
        if (left != null) {
            max = Math.max(left.getMax(), max);
            min = Math.min(left.getMin(), min);
        }
        if (right != null) {
            max = Math.max(right.getMax(), max);
            min = Math.min(right.getMin(), min);
        }
        boolean isAllBST = (left == null || x.val > left.getMax()) && (right == null || x.val < right.getMin())
                && (left == null || left.isAllBST()) && (right == null || right.isAllBST());
        int leftMaxSub = left == null ? 0 : left.getMaxSubBSTSize();
        int rightMaxSub = right == null ? 0 : right.getMaxSubBSTSize();
        int maxSubSize = isAllBST ? leftMaxSub + rightMaxSub + 1 : Math.max(left == null ? 0 : left.getMaxSubBSTSize(), right == null ? 0 : right.getMaxSubBSTSize());
        return new FindSearchTreeCount(max, min, isAllBST, maxSubSize);
    }
}
