package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;
import com.uchia.leetcode.structure.ListNode;

public class ReorderList143 {

    /**
     * 合并以及 快慢指针 p= l1.next 而不是 p = p.next
     * @param head
     */
    // bytedance meituan amazon
    public void reorderList(ListNode head) {
        ListNode l1 = head;
        ListNode mid = middleOfList(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeTwoList(l1, l2);
    }


    private ListNode middleOfList(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private void mergeTwoList(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null){
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;

            p1.next = p2;
            p2.next = p1Next;

            p1 = p1Next;
            p2 = p2Next;

        }
    }

    public static void main(String[] args) {
        ListNode node = Utils.generateLisNode(new int[]{
                1,2,3,4
        });

        ReorderList143 list143 = new ReorderList143();
        list143.reorderList(node);

        Utils.printListNodes(node);
    }
}
