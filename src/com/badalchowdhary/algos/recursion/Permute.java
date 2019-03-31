package com.badalchowdhary.algos.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permute
{
    public static List<String> permute(String input)
    {
        List<String> result = new ArrayList<>();
        permuteHelper("", input, result);

        return result;
    }

    private static void permuteHelper(String soFar, String rest, List<String> result)
    {
        if (rest.equals(""))
        {
            result.add(soFar);
        }
        else
        {
            for (int i = 0; i < rest.length(); i++)
            {
                String next = soFar + rest.charAt(i);
                String remaining = rest.substring(0, i) + rest.substring(i + 1);
                permuteHelper(next, remaining, result);
            }
        }
    }

    public static void main(String[] args)
    {
        List<String> result = permute("ABC");
        System.out.println(result);
    }

}
