package com.uchia.leetcode.top100;

import com.uchia.leetcode.structure.TreeNode;

import java.util.*;

public class RightSideView199 {
    // facebook bytedance amazon
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        if (root != null){
            queue.add(new Pair<>(root,0));
        }

        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> item = queue.poll();
            int nextLevel = item.second + 1;
            if (list.size() - 1 >= item.second){
                list.add(item.first.val);
            } else {
                list.set(item.second,item.first.val);
            }

            if (item.first.left != null){
                queue.add(new Pair<>(item.first.left,nextLevel));
            }

            if (item.first.right != null){
                queue.add(new Pair<>(item.first.right,nextLevel));
            }
        }


        return list;
    }


    class Pair<K,V>{
        public K first;
        public V second;

        public Pair(K f,V s){
            this.first = f;
            this.second = s;
        }
    }
}
