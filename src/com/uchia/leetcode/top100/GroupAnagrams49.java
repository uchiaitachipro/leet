package com.uchia.leetcode.top100;

import java.util.*;

public class GroupAnagrams49 {
    // amazon microsoft eBay
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0 ;i < strs.length; i++){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if (!map.containsKey(key)){
                map.put(key,new LinkedList<>());
            }
            map.get(key).add(strs[i]);
        }

        return new LinkedList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        System.out.println(groupAnagrams49.groupAnagrams(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        }));
    }
}
