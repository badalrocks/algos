package com.badalchowdhary.algos.recursion;
import java.util.*;

public class CoinChange1 {
    
    // [1 2 5], 11
public int coinChange(int[] coins, int amount) {
        
        Arrays.sort(coins);
        
        return coinChangeHelper(coins, amount, 0);
        
    }
    
    private int coinChangeHelper(int[] coins, int amount, int result)
    {
        if (amount == 0)
        {
            return result;
        }
        
        for (int i=coins.length-1; i>=0; i--)
        {
            if (amount - coins[i] >= 0)
            {
                int temp = coinChangeHelper(coins, amount - coins[i], result+1);
                if (temp > 0)
                {
                    return temp;
                }
            }
        }
        
        return -1;
    }
    // cch(c, 11, 0) 5
    // cch(c, 6, 1) 5
    // cch(c, 1, 2)
    
    public static void main(String[] args)
    {
        CoinChange1 s = new CoinChange1();
        int numCoins = s.coinChange(new int[]{2, 5, 10}, 31);
        System.out.println(numCoins);
    }
    
}