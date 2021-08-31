package com.uchia.leetcode.top100;

import com.uchia.leetcode.structure.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CopyRandomList138 {
    // amazon facebook microsoft
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Map<Node,Node> index = new LinkedHashMap<>();
        Node root = new Node(head.val);
        index.put(head,root);
        Node currentSourcePivot = head;
        Node currentTargetPivot = root;
        while (currentSourcePivot.next != null){
            Node node =  currentSourcePivot.next;
            Node copyNode = new Node(node.val);
            currentTargetPivot.next = copyNode;
            index.put(node,copyNode);
            currentSourcePivot = node;
            currentTargetPivot = copyNode;
        }

        currentSourcePivot = head;

        while (currentSourcePivot != null){
            Node randomNode = currentSourcePivot.random;
            Node copyNode = index.get(currentSourcePivot);
            Node copyOfRandomNode = index.get(randomNode);
            copyNode.random = copyOfRandomNode;
            currentSourcePivot = currentSourcePivot.next;
        }

        return root;
    }
}
