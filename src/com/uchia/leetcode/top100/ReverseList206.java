package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;
import com.uchia.leetcode.structure.ListNode;

public class ReverseList206 {

    private ListNode reverseHead = null;


    public ListNode reverseList(ListNode head) {
        _reverseList(head);
        return reverseHead;
    }

    // bytedance tencent amazon
    public ListNode _reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            reverseHead = head;
            return head;
        }

        ListNode prev = _reverseList(head.next);
        if (prev != null){
            prev.next = head;
        }
        head.next = null;
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
        ListNode node6 = new ListNode(6);
        node5.next = node6;

        ReverseList206 reverseList206 = new ReverseList206();
        Utils.printListNodes(reverseList206.reverseList(node1));
    }

}
