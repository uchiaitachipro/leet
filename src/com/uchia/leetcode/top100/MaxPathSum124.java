package com.uchia.leetcode.top100;

import com.uchia.leetcode.structure.TreeNode;

public class MaxPathSum124 {
    int maxSum = Integer.MIN_VALUE;

    // facebook bytedance amazon
    public int maxPathSum(TreeNode root) {
        _maxPathSum(root);
        return maxSum;
    }

    private int _maxPathSum(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null&& root.right == null){
            maxSum = Math.max(maxSum,root.val);
            return root.val;
        }

        int leftSum = Math.max(_maxPathSum(root.left),0);
        int rightSum = Math.max(_maxPathSum(root.right),0);

        maxSum = Math.max(leftSum + rightSum +root.val,maxSum);
        return root.val + Math.max(leftSum,rightSum);
    }
}
