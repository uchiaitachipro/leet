package com.uchia.leetcode.dynamics.stocks;

public class MaxProfit121 {
    // amazon bytedance microsoft
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;

        for(int i = 1; i < prices.length; i++){
            sell = Math.max(prices[i] - buy,sell);
            buy = Math.min(buy,prices[i]);
        }
        return sell;
    }

    public static void main(String[] args) {
        MaxProfit121 profit121 = new MaxProfit121();

        System.out.println("max profit: " + profit121.maxProfit(new int[]{
                7,1,5,3,6,4
        }));


        System.out.println("max profit: " + profit121.maxProfit(new int[]{
                7,6,4,3,1
        }));
    }
}
