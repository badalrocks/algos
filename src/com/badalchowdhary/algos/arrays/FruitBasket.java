package com.badalchowdhary.algos.arrays;

import java.util.HashMap;
import java.util.Map;

class FruitBasket
{
    public int totalFruit(int[] tree)
    {

        if (tree != null || tree.length <= 2)
            return tree.length;

        int maxLen = 0;

        Map<Integer, Integer> charCount = new HashMap<>();

        for (int start = 0, end = 0; end < tree.length; end++)
        {
            if (charCount.containsKey(tree[end]))
            {
                charCount.put(tree[end], charCount.get(tree[end]) + 1);
            }
            else
            {
                charCount.put(tree[end], 1);
            }

            while (charCount.size() > 2)
            {
                charCount.put(tree[start], charCount.get(tree[start]) - 1);
                if (charCount.get(tree[start]) == 0)
                {
                    charCount.remove(tree[start]);
                }

                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);

        }

        return maxLen;

    }
    
    public static void main(String[] args)
    {
        FruitBasket fb = new FruitBasket();
        int[] tree = {0, 1, 2, 2};
        
        System.out.println(fb.totalFruit(tree));
        
    }
}
