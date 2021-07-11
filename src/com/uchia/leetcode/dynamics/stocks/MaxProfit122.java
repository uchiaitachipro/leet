package com.uchia.leetcode.dynamics.stocks;

public class MaxProfit122 {

    //amazon bytedance apple
    public int maxProfit(int[] prices) {
        int dpSell = 0;
        int dpBuy = -prices[0];
        for (int i =0; i < prices.length; i++){
            dpSell = Math.max(dpSell,dpBuy + prices[i]);
            dpBuy = Math.max(dpBuy,dpSell - prices[i]);
        }
        return dpSell;
    }

    public static void main(String[] args) {
        MaxProfit122 profit122 = new MaxProfit122();

        System.out.println("max: " + profit122.maxProfit(new int[]{
                7,1,5,3,6,4
        }));

        System.out.println("max: " + profit122.maxProfit(new int[]{
                1,2,3,4,5
        }));
    }

}
