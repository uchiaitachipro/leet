package com.uchia.leetcode.top100;

import java.util.*;

/**
 * facebook amazon linkedin
 */
public class RandomizedSet380 {
    private List<Integer> elements = new ArrayList<>();
    private Map<Integer, Integer> idx = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet380() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (idx.containsKey(val)) {
            return false;
        }

        idx.put(val, elements.size());
        elements.add(elements.size(),val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     *
     * 少了往map更新最后一个元素位置
     */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }

        int lastValue = elements.get(elements.size() - 1);
        int deleteIndex = idx.get(val);
        elements.set(deleteIndex, lastValue);
        idx.put(lastValue,deleteIndex);
        elements.remove(elements.size() - 1);
        idx.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return elements.get((int)(Math.random() * elements.size()));
    }
}
