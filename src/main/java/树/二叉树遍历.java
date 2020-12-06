package 树;

import type.TreeNode;
import type.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    // 后序遍历 无递归
    public static void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(head);
        for (TreeNode c; !stack.isEmpty(); ) {
            c = stack.peek();
            if (c != null && c.left != head && c.right != head) {
                stack.push(c.left);
            } else if (c != null && c.right != head) {
                stack.push(c.right);
            } else {
                TreeNode pop = stack.pop();
                if (pop != null) {
                    System.out.print(pop.val);
                }
                head = c;
            }
        }
    }

    public static void main(String[] args) {
        pos(TreeUtils.defaultTree());
    }
}
