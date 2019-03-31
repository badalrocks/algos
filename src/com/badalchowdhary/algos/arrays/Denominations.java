package com.badalchowdhary.algos.arrays;

import java.util.Arrays;

public class Denominations
{
    public static void main(String[] args)
    {
        int amount = 3;
        int[] den = { 1, 2 };
        // System.out.println(changePossibilities(amount, den));
        System.out.println(changePossibilitiesTopDown(amount, den));
    }

    public static int changePossibilitiesTopDown(int amount, int[] denominations)
    {
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex)
    {
        System.out.println("\ncalling amountLeft: " + amountLeft + " , den: " + Arrays.toString(denominations)
                + " , currentIndex: " + currentIndex);

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0)
        {
            System.out.println("amount left is 0");
            return 1;
        }

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0)
        {
            System.out.println("amount < 0");
            return 0;
        }

        // we're out of denominations
        if (currentIndex == denominations.length)
        {
            System.out.println("currentIndex = den.length");
            return 0;
        }

        System.out.printf("checking ways to make %d with %s\n", amountLeft,
                Arrays.toString(Arrays.copyOfRange(denominations, currentIndex, denominations.length)));

        // choose a current coin
        int currentCoin = denominations[currentIndex];
        System.out.println("currentCoin: " + currentCoin);

        // see how many possibilities we can get for each number of times to use currentCoin.
        int numPossibilities = 0;
        while (amountLeft >= 0)
        {
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations, currentIndex + 1);
            System.out.println("amount left = " + amountLeft + " - " + currentCoin);
            amountLeft -= currentCoin;
        }

        System.out.println("****returning numPossibilities: " + numPossibilities + "\n");

        return numPossibilities;
    }

    // public static int changePossibilities(int amount, int[] denominations)
    // {
    //
    // // calculate the number of ways to make change
    // if (amount < 0 || denominations == null || denominations.length <= 0)
    // {
    // throw new IllegalArgumentException(
    // "Invalid input. Amount must greater than 0 and denominations must have
    // atleast 1 element.");
    // }
    //
    // int numWays = 0;
    // for (int i = 0; i < denominations.length; i++)
    // {
    // int current = denominations[i];
    //
    // if (amount % current == 0)
    // {
    // numWays++;
    // }
    //
    // for (int j = i + 1; j < denominations.length; j++)
    // {
    // int multiplier = 1;
    // int prod = multiplier * denominations[j];
    //
    // while (prod < amount)
    // {
    // int diff = amount - prod;
    // if (diff % current == 0)
    // {
    // numWays++;
    // }
    //
    // multiplier++;
    // prod = multiplier * denominations[j];
    // }
    // }
    // }
    //
    // return numWays;
    //
    // }

}
