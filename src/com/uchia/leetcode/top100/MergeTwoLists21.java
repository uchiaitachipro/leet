package com.uchia.leetcode.top100;

import com.uchia.leetcode.structure.ListNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class MergeTwoLists21 {
    //amazon bytedance tencent
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null){
            return l1;
        } else if (l1 == null){
            return l2;
        } else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;


        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        node11.next = node22;
        ListNode node33 = new ListNode(4);
        node22.next = node33;

        MergeTwoLists21 lists21 = new MergeTwoLists21();

        System.out.println("result" + lists21.mergeTwoLists(node1,node11));
    }
}
