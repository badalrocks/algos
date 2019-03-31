package com.badalchowdhary.interviewcake;

import java.math.BigInteger;

public class Problem1MaxProfitStocks
{

    public static long getMaxProfit(int[] stockPrices)
    {
        // TODO do boundary checks.
        doBoundaryChecks(stockPrices);

        int minPrice = Math.min(stockPrices[0], stockPrices[1]);
        long maxProfit = (long) stockPrices[1] - stockPrices[0];

        for (int i = 2; i < stockPrices.length; i++)
        {
            int currentPrice = stockPrices[i];

            int potentialProfit = currentPrice - minPrice;

            maxProfit = Math.max(maxProfit, potentialProfit);

            minPrice = Math.min(minPrice, currentPrice);

        }

        return maxProfit;

    }

    private static void doBoundaryChecks(int[] stockPrices)
    {
        if (stockPrices == null)
        {
            throw new IllegalArgumentException("stockPrices cannot be null.");
        }

        if (stockPrices.length < 2)
        {
            throw new IllegalArgumentException("stockPrices must have minimum length 2.");
        }

    }

    public static void main(String[] args)
    {
        int[] sp1 = { 10, 7, 5, 8, 11, 9 };
        System.out.println("sp1: " + getMaxProfit(sp1));

        int[] sp2 = { 20, 6, 4, 11, 9, 30 };
        System.out.println("sp2: " + getMaxProfit(sp2));

        int[] sp3 = { 10, 7, 5, 8 };
        System.out.println("sp3: " + getMaxProfit(sp3));

        int[] sp4 = { 10, 8, 6, 1 };
        System.out.println("sp4: " + getMaxProfit(sp4));

        int[] sp5 = { 10 };
        System.out.println("sp5: " + getMaxProfit(sp5));
        
        int[] sp6 = { 10, 8, 6, 1 };
        System.out.println("sp6: " + getMaxProfit(sp6));

    }

}
