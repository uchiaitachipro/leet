package com.uchia.leetcode.dynamics.stocks;

public class MaxProfit123 {
    // amazon bytedance tufu google
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;

        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }

    public static void main(String[] args) {
        MaxProfit123 profit123 = new MaxProfit123();
        System.out.println(profit123.maxProfit(new int[]{
                3,3,5,0,0,3,1,4
        }));

        System.out.println(profit123.maxProfit(new int[]{
                7,6,4,3,1
        }));

        System.out.println(profit123.maxProfit(new int[]{
               1
        }));
    }
}
