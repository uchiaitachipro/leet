package com.uchia.leetcode.top100;

import java.util.*;

public class TopKFrequent692 {
    // amazon microsoft apple
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                int firstCount = map.get(s);
                int secondCount = map.get(t1);
                if (firstCount == secondCount) {
                    return s.compareTo(t1);
                }
                return secondCount - firstCount;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
        }

        List<String> result = new LinkedList<>();

        for (int i = 0; i < k; i++){
            if (!queue.isEmpty()){
                result.add(queue.poll());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent692 frequent692 = new TopKFrequent692();
        System.out.println("result: " + frequent692.topKFrequent(new String[]{
                "i", "love", "leetcode", "i", "love", "coding"
        },2));

        System.out.println("result: " + frequent692.topKFrequent(new String[]{
                "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        },4));
    }
}
