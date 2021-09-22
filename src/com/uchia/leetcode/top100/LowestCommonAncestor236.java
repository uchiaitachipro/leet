package com.uchia.leetcode.top100;

import com.uchia.leetcode.structure.TreeNode;

public class LowestCommonAncestor236 {

    // facebook bytedance microsoft
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if (root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left != null && right != null){
            return root;
        }

        if (left == null && right == null){
            return null;
        }

        return left == null ? right :left;
    }
}
