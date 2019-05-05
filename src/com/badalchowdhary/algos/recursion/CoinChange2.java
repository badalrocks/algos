package com.badalchowdhary.algos.recursion;

import java.util.*;

public class CoinChange2
{

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    // [1 2 5], 11
    public int coinChange(int[] coins, int amount)
    {
        if (memo.containsKey(amount))
        {
            return memo.get(amount);
        }
        //System.out.println(Arrays.toString(coins) + ", " + amount);
        if (amount <= 0)
        {
            return 0;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < coins.length; i++)
        {
            if (amount < coins[i])
            {
                continue;
            }

            int temp = 1 + coinChange(coins, amount - coins[i]);
            result.add(temp);
            
        }

        //System.out.println(Arrays.toString(coins) + ", " +  amount + ", " + result);
        
        if (result.size() == 0)
        {
            memo.put(amount, -1);
            return -1;
        }
        else
        {
            List<Integer> temp = new ArrayList<>();
            for (int r : result)
            {
                if (r!=0)
                {
                    temp.add(r);
                }
            }
            
            int finalResult = temp.size() > 0 ? Collections.min(temp) : -1;
            memo.put(amount, finalResult);
            return finalResult;
        }
        

    }

    public static void main(String[] args)
    {
        CoinChange2 s = new CoinChange2();
        int numCoins = s.coinChange(new int[] {3, 5, 10 }, 61);
        System.out.println(numCoins);
    }

}