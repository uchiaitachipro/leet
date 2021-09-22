package com.uchia.leetcode.top100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest215 {
    // facebook bytedance amazon
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if (queue.peek().intValue() < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        FindKthLargest215 findKthLargest215 = new FindKthLargest215();

        System.out.println(findKthLargest215.findKthLargest(
                new int[]{
                        3,2,3,1,2,4,5,5,6
                },
                4
        ));
    }
}
