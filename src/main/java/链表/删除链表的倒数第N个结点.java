package 链表;

import type.ListNode;

public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null && n > 0) {
            return null;
        }
        ListNode tmp = new ListNode(0, head);
        ListNode l1 = head;
        for (int i = 0; i < n; ++i) {
            l1 = l1.next;
        }
        ListNode l2 = tmp;
        while (l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;

        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);

        删除链表的倒数第N个结点 test = new 删除链表的倒数第N个结点();
        ListNode listNode = test.removeNthFromEnd(l1, 1);
        System.out.println(listNode);
    }
}
