package com.badalchowdhary.algos.recursion;

import java.util.HashMap;
import java.util.Map;

public class NChooseK
{

    public static int nChooseK(int n, int k)
    {
        System.out.println("calling n: " + n + ", k: " + k);
        if (n == k)
            return 1;
        if (k == 1)
            return n;

        return nChooseK(n - 1, k - 1) + nChooseK(n - 1, k);
    }

    public static int nChooseKDp(int n, int k)
    {
        Map<String, Integer> memo = new HashMap<>();
        nChooseKMemoDpHelper(n, k, memo);

        return memo.get(n + "-" + k);
    }

    private static void nChooseKMemoDpHelper(int n, int k, Map<String, Integer> memo)
    {
        String key = n + "-" + k;
        if (n == k)
            memo.put(key, 1);
        if (k == 1)
            memo.put(key, n);

        if (!memo.containsKey(key))
        {
            System.out.println("computing n: " + n + ", k: " + k);
            int result = nChooseKDp(n - 1, k - 1) + nChooseKDp(n - 1, k);

            System.out.println("adding in memo n: " + n + ", k: " + k);
            memo.put(key, result);
        }
        /*else
        {
            System.out.println("already computed n: " + n + ", k: " + k);
        }*/

    }

    public static void main(String[] args)
    {
        //System.out.println(nChooseK(7, 5));
        System.out.println(nChooseKDp(7, 5));
    }

}
