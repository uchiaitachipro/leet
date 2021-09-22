package com.uchia.leetcode.top100;

import com.uchia.leetcode.structure.TreeNode;

public class IsValidBST98 {
    // bytedance amazon facebook
    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean _isValidBST(TreeNode root,long lowBound,long upBound){
        if (root == null){
            return true;
        }

        if (root.val <= lowBound || root.val >= upBound){
            return false;
        }

        return _isValidBST(root.left, lowBound,root.val) && _isValidBST(root,root.val,upBound);
    }
}
