package com.badalchowdhary.interviewcake;

import java.util.Arrays;

public class MakeChangeParker
{
    public static int changePossibilitiesTopDown(int amount, int[] denominations)
    {
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex)
    {
        for (int i = 0; i < currentIndex; i++)
        {
            System.out.print("    ");

        }
        System.out.println("amountLeft: " + amountLeft + ", currentIndex: " + currentIndex);
        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0)
        {
/*            for (int i = 0; i < currentIndex; i++)
            {
                System.out.print("    ");

            }
            System.out.println("found possibility");*/
            return 1;
        }

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0)
        {
            return 0;
        }

        // we're out of denominations
        if (currentIndex == denominations.length)
        {
            return 0;
        }

        /*
         * System.out.printf("checking ways to make %d with %s\n", amountLeft,
         * Arrays.toString(Arrays.copyOfRange(denominations, currentIndex,
         * denominations.length)));
         */

        // choose a current coin
        int currentCoin = denominations[currentIndex];

        // see how many possibilities we can get
        // for each number of times to use currentCoin
        int numPossibilities = 0;
        while (amountLeft >= 0)
        {
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations, currentIndex + 1);
            amountLeft -= currentCoin;
/*            for (int i = 0; i <= currentIndex; i++)
            {
                System.out.print("    ");

            }
            System.out.println("current coin: " + currentCoin);*/
        }

        return numPossibilities;
    }

    public static void main(String[] args)
    {
        int amount = 5;
        int[] den = { 3, 2, 1 };
        System.out.println(changePossibilitiesTopDown(amount, den));

    }

}
