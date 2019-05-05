package com.badalchowdhary.algos.recursion;

import java.util.*;

public class CoinChangeNumWaysTopDown
{

    
    public int coinChange(int[] coins, int amount, int result)
    {
        
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        
        for (int i=0; i<coins.length; i++)
        {
            // including coin
            result += coinChange(coins, amount-coins[i], 0);
            
            // excluding coin
            int[] newCoins = new int[coins.length-1];
            for (int c : coins)
            {
                if (c != coins[i])
                {
                    newCoins[i++] = c;
                }
            }
            
            result += coinChange(newCoins, amount, 0);
        }
        
        return result;

    }

    public static void main(String[] args)
    {
        CoinChangeNumWaysTopDown s = new CoinChangeNumWaysTopDown();
        int numWays = s.coinChange(new int[] {1, 2, 5 }, 8, 0);
        System.out.println(numWays);
    }

}