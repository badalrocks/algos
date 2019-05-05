package com.badalchowdhary.algos.dp;

public class RodCutter
{

    private static int getMaxValFromCuttingRod1(int[] cost)
    {
        int[] rod = new int[cost.length];
        rod[0] = 0;

        for (int i = 1; i < cost.length; i++)
        {
            int maxVal = 0;
            for (int j = 1; j <= i; j++)
            {
                int currVal = cost[j] + rod[i - j];
                maxVal = Math.max(maxVal, currVal);
            }

            rod[i] = maxVal;
        }

        System.out.println(java.util.Arrays.toString(rod));

        return rod[rod.length - 1];
    }

    private static int getMaxValFromCuttingRod(int[] cost)
    {
        int[] rod = new int[cost.length];
        for (int i = 0; i < cost.length; i++)
        {
            int maxProfit = cost[i];
            for (int j = 0; j <= i / 2; j++)
            {
                maxProfit = Math.max(maxProfit, rod[j] + rod[i - j]);
            }
            rod[i] = maxProfit;
        }

        return rod[rod.length - 1];
    }

    public static void main(String[] args)
    {
        int[] cost = { 0, 2, 4, 5, 7 };

        System.out.println(getMaxValFromCuttingRod(cost));

    }

}
