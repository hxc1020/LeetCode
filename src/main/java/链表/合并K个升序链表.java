package 链表;

import type.ListNode;

import java.util.PriorityQueue;

public class 合并K个升序链表 {
    public ListNode 偷懒用Java的PriorityQueue(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                heap.add(list.val);
                list = list.next;
            }
        }
        ListNode tmp = new ListNode();
        ListNode result;
        result = tmp;
        while (heap.size() > 0) {
            tmp.next = new ListNode(heap.poll());
            tmp = tmp.next;
        }
        return result.next;
    }
}
