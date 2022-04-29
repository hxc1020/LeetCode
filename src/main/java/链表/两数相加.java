package 链表;

import type.ListNode;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next == null && l1.val == 0) {
            return l2;
        }
        if (l2.next == null && l2.val == 0) {
            return l1;
        }
        ListNode s1 = l1;
        ListNode s2 = l2;
        ListNode result = new ListNode(0);
        ListNode r = result;
        int carry = 0;

        while (s1 != null || s2 != null) {
            if (s1 == null) {
                r.next = new ListNode((carry + s2.val) % 10);
                carry = (carry + s2.val) / 10;
                s2 = s2.next;
                r = r.next;
                continue;
            }
            if (s2 == null) {
                r.next = new ListNode((carry + s1.val) % 10);
                carry = (carry + s1.val) / 10;
                s1 = s1.next;
                r = r.next;
                continue;
            }
            r.next = new ListNode((carry + s1.val + s2.val) % 10);
            carry = (carry + s1.val + s2.val) / 10;
            s1 = s1.next;
            s2 = s2.next;
            r = r.next;
        }
        if (carry > 0) {
            r.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        两数相加 test = new 两数相加();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = test.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
