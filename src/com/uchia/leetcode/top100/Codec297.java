package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;
import com.uchia.leetcode.structure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Codec297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder path) {
        if (root == null) {
            path.append("NIL,");
            return;
        }
        path.append(root.val).append(",");
        serialize(root.left, path);
        serialize(root.right, path);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] node = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(node));

        if (queue.isEmpty()) {
            return null;
        }

        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> node) {
        if (node.isEmpty()) {
            return null;
        }

        String res = node.poll();

        if (Objects.equals(res, "") || Objects.equals(res, "NIL")) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(res);

        root.left = deserialize(node);
        root.right = deserialize(node);

        return root;
    }


    public static void main(String[] args) {
        TreeNode root = Utils.generateTreeNode(new Integer[]{
                1, 2, 3, null, null, 4, 5
        });

        Codec297 codec297 = new Codec297();
        String str = codec297.serialize(root);
        System.out.println("serialize: " + str);

        codec297.deserialize(str);
    }
}
