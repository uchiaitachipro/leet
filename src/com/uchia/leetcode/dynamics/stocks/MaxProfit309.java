package com.uchia.leetcode.dynamics.stocks;

public class MaxProfit309 {
    // bytedance amazon facebook
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        int[] freeze = new int[prices.length + 1];
        freeze[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, freeze[i - 1] - prices[i]);
            sell = Math.max(sell, buy + prices[i]);
            freeze[i + 1] = sell;
        }

        return sell;
    }

    public static void main(String[] args) {
        MaxProfit309 profit309 = new MaxProfit309();

        System.out.println("profit: " + profit309.maxProfit(new int[]{
                1, 2, 3, 0, 2
        }));
    }
}
