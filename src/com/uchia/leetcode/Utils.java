package com.uchia.leetcode;

import com.uchia.leetcode.structure.ListNode;
import com.uchia.leetcode.structure.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static void printArrays(int[][] arrays) {
        Arrays.stream(arrays).map(p -> Arrays.toString(p)).forEach(p -> {
            System.out.print(p + " ");
        });
        System.out.println();
    }

    public static void printListNodes(ListNode node) {
        ListNode start = node;
        StringBuilder sb = new StringBuilder();
        while (start != null) {
            sb.append(start.val).append(" ");
            start = start.next;
        }
        System.out.println("result: " + sb.toString());
    }

    public static <T> void printList2D(List<List<T>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        list.forEach((li) -> {

            StringBuilder lib = new StringBuilder();
            lib.append("[ ");

            li.forEach((ele) -> {
                lib.append(ele).append(" ");
            });

            lib.append("]");
            sb.append(lib).append(",");
        });

        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");

        System.out.println(sb.toString());
    }


    public static TreeNode generateTreeNode(Integer[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int len = nums.length;
        int index = 0;
        TreeNode head = new TreeNode(nums[index]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(head);
        TreeNode cur;
        while (index < len) {
            index++;
            if (index >= len) return head;
            cur = nodeQueue.poll();
            Integer left = nums[index];
            if (left != null) {
                cur.left = new TreeNode(left);
                nodeQueue.offer(cur.left);
            }

            index++;
            if (index >= len) return head;
            Integer right = nums[index];
            if (right != null) {
                cur.right = new TreeNode(right);
                nodeQueue.offer(cur.right);
            }
        }
        return head;
    }
}
