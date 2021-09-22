package com.uchia.leetcode.top100;

import com.uchia.leetcode.structure.ListNode;

public class MergeKLists23 {

    // amazon bytedance facebook
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        return mergeTwoList(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    private ListNode mergeTwoList(ListNode first, ListNode second) {
        if (first == null || second == null) {
            return first == null ? second : first;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode p1 = first;
        ListNode p2 = second;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        tail.next = (p1 != null ? p1 : p2);

        return dummy.next;
    }

}
