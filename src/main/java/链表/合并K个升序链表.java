package 链表;

import type.ListNode;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 合并K个升序链表 {

    class 偷懒用Java的PriorityQueue {
        public ListNode solution(ListNode[] lists) {
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

    class 归并 {
        public ListNode solution(ListNode[] lists) {
            LinkedList<ListNode> queue = new LinkedList<>();
            for (int i = 0; i < lists.length; i += 2) {
                if (i + 1 == lists.length) {
                    queue.offerFirst(lists[i]);
                    break;
                }
                queue.offerFirst(mergeTwoLists(lists[i], lists[i + 1]));
            }
            while (queue.size() != 1) {
                ListNode l1 = queue.pollLast();
                ListNode l2 = queue.pollLast();
                queue.offerFirst(mergeTwoLists(l1, l2));
            }
            return queue.pollLast();
        }

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
    }

}
