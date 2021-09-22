package com.uchia.leetcode.top100;

import com.uchia.leetcode.Utils;
import com.uchia.leetcode.structure.TreeNode;

public class IsSubtree572 {


    // amazon bytedance microsoft
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        return dfs(root, subRoot);
    }


    private boolean dfs(TreeNode root, TreeNode subRoot){
        if (root == null){
            return false;
        }

        return check(root, subRoot) || dfs(root.left,subRoot) || dfs(root.right,subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot){
        if (root ==null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null || subRoot.val != root.val){
            return false;
        }
        return check(root.left,subRoot.left) && check(root.right,subRoot.right);
    }


    public static void main(String[] args) {
        TreeNode root = Utils.generateTreeNode(new Integer[]{
                3,4,5,1,2
        });
        TreeNode subRoot = Utils.generateTreeNode(new Integer[]{
                4,1,2
        });

        IsSubtree572 subtree572 = new IsSubtree572();

        System.out.println("is sub tree: " + subtree572.isSubtree(root,subRoot));
    }

}
