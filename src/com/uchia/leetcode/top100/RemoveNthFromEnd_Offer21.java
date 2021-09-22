package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;
import com.uchia.leetcode.structure.ListNode;

public class RemoveNthFromEnd_Offer21 {
    int lastKth = -1;

    //facebook amazon bytedance
    public ListNode removeNthFromEnd(ListNode head, int k) {
        return _removeNthFromEnd(head, k);
    }

    public ListNode _removeNthFromEnd(ListNode head, int k) {

        if (head == null) {
            lastKth = 0;
            return null;
        }

        ListNode node = _removeNthFromEnd(head.next, k);
        lastKth++;
        if (lastKth == k) {
            return node;
        }
        head.next = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        RemoveNthFromEnd_Offer21 offer21 = new RemoveNthFromEnd_Offer21();
        Utils.printListNodes(offer21.removeNthFromEnd(node1,1));
    }

}
