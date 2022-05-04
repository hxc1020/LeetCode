package 链表;

import type.ListNode;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p = new ListNode();
        ListNode tmp = new ListNode();
        if (list1.val > list2.val) {
            p.next = list1;
            merge(list2, p, tmp);
            return list2;
        } else {
            p.next = list2;
            merge(list1, p, tmp);
            return list1;
        }
    }

    private void merge(ListNode r, ListNode l, ListNode t) {
        if (l == null || l.next == null) {
            return;
        }
        if (r.next == null) {
            r.next = l.next;
            return;
        }
        if (r.next.val >= l.next.val) {
            t.next = r.next;
            r.next = l.next;
            l.next = l.next.next;
            r.next.next = t.next;
        }
        r = r.next;
        merge(r, l, t);
    }

    public static void main(String[] args) {
        合并两个有序链表 test = new 合并两个有序链表();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = test.mergeTwoLists(l1, l2);
        System.out.println(result);
    }
}
