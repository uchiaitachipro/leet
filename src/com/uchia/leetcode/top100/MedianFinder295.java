package com.uchia.leetcode.top100;

import java.util.PriorityQueue;

/**
 * amazon microsoft apple
 */
public class MedianFinder295 {

    private PriorityQueue<Integer> qMin;
    private PriorityQueue<Integer> qMax;


    /**
     * initialize your data structure here.
     */
    public MedianFinder295() {
        qMin = new PriorityQueue<>((a, b) -> b - a);
        qMax = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (qMin.isEmpty() || num <= qMin.peek()) {
            qMin.offer(num);
            if (qMax.size() + 1 < qMin.size()) {
                qMax.offer(qMin.poll());
            }
        } else {
            qMax.offer(num);
            if (qMax.size() > qMin.size()) {
                qMin.offer(qMax.poll());
            }
        }
    }

    public double findMedian() {
        if (qMin.size() > qMax.size()) {
            return qMin.peek();
        }
        return (qMin.peek() + qMax.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder295 finder295 = new MedianFinder295();
        finder295.addNum(1);
        finder295.addNum(2);

        System.out.println("result:"  + finder295.findMedian());

        finder295.addNum(3);
        System.out.println("result:"  + finder295.findMedian());

    }
}
