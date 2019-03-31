package com.badalchowdhary.algos.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermuteTest
{

    public static List<String> permute(String s)
    {
        
        if (s.length() <= 1)
        {
            List<String> res = new ArrayList<String>();
            res.add(s);
            return res;
        }
        
        String first = s.substring(0, 1);
        String remaining = s.substring(1);
        
        List<String> result = permute(remaining);
        List<String> newresult = new ArrayList<String>();
        for (String r : result)
        {
            for (int i=0; i<=r.length(); i++)
            {
                //String permutation = r.substring(0,i) + first + r.substring(i+1);
                String permutation = r.substring(0,i) + first + r.substring(i);
                newresult.add(permutation);
            }
        }

        return newresult;
    }

    public static void main(String[] args)
    {
        String input = "ABCDE";
        List<String> result = permute(input);
        System.out.println(result);

    }

}
