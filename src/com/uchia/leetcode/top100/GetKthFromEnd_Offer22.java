package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;
import com.uchia.leetcode.structure.ListNode;

public class GetKthFromEnd_Offer22 {

    int lastKth = -1;

    //bytedance tencent microsoft
    public ListNode getKthFromEnd(ListNode head, int k) {
        return _getKthFromEnd(head, k);
    }

    public ListNode _getKthFromEnd(ListNode head, int k) {

        if (head == null) {
            lastKth = 0;
            return null;
        }

        ListNode node = _getKthFromEnd(head.next, k);
        lastKth++;
        if (lastKth == k) {
            return head;
        }
        return node;
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
        ListNode node6 = new ListNode(6);
        node5.next = node6;

        GetKthFromEnd_Offer22 offer22 = new GetKthFromEnd_Offer22();
        Utils.printListNodes(offer22.getKthFromEnd(node1,3));
    }

}
