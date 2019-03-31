package com.badalchowdhary.algos.recursion;

public class MakingChange
{

    // Brute force solution. Go through every
    // combination of coins that sum up to c to
    // find the minimum number
    private static int[] coins = new int[] { 5, 2, 1 };

    public static int makeChange(int c)
    {
        //System.out.println("makeChange(" + c + ")");
        if (c == 0)
        {
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;
        // Try removing each coin from the total and
        // see how many more coins are required
        for (int coin = 0; coin < coins.length; coin++)
        {
        
            for (int i=0; i<coin; i++)
            {
                System.out.print("    ");
            }
        
            System.out.println("makeChange(" + c + "), current coin: " + coins[coin]);
            // Skip a coin if it’s value is greater
            // than the amount remaining
            if (c - coins[coin] >= 0)
            {
                int currMinCoins = makeChange(c - coins[coin]);

                if (currMinCoins < minCoins)
                {
                    minCoins = currMinCoins;
                    //System.out.println("updating minCoins: " + minCoins);
                }

            }
        }
        // Add back the coin removed recursively
        //System.out.println("returning: " + minCoins + 1);
        return minCoins + 1;
    }

    public static void main(String[] args)
    {
        int result = makeChange(6);
        System.out.println(result);
    }
}
