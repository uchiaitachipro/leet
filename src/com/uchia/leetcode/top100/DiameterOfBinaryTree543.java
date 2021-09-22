package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;
import com.uchia.leetcode.structure.TreeNode;

public class DiameterOfBinaryTree543 {

    private int globalMaxLength = 0;

    // facebook bytedance amazon
    public int diameterOfBinaryTree(TreeNode root) {
        _diameterOfBinaryTree(root);
        return globalMaxLength - 1;
    }


    private int _diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(_diameterOfBinaryTree(root.left), 0);
        int rightMax = Math.max(_diameterOfBinaryTree(root.right), 0);

        globalMaxLength = Math.max(leftMax + rightMax + 1, globalMaxLength);

        return Math.max(leftMax, rightMax) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = Utils.generateTreeNode(new Integer[]{
            1,2,3,4,5
        });
        DiameterOfBinaryTree543 tree543 = new DiameterOfBinaryTree543();
        System.out.println(tree543.diameterOfBinaryTree(root));
    }

}
